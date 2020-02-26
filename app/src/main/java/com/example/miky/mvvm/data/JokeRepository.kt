package com.example.miky.mvvm.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class JokeRepository private constructor() {
    private val remoteSource = JokeRemoteRepository()
    var jokeList: MutableLiveData<ArrayList<Joke>> = MutableLiveData<ArrayList<Joke>>()

    companion object {
        private val sInstance: JokeRepository by lazy { JokeRepository() }

        fun getInstance(): JokeRepository {
            return sInstance
        }
    }

    fun getLiveDataForList(): MutableLiveData<ArrayList<Joke>> {

        if (jokeList.value == null) {
            Log.i("miky", "jokelist if null")
        }


        jokeList.value?:let {
            Log.i("miky", "jokelist let null")
            requestList()
        }

        return jokeList
    }

    fun requestList() {
        remoteSource.requestList {
            jokeList.postValue(it)
        }
    }

    fun getJoke(position: Int): Joke? {
        return jokeList.value?.get(position) ?:null
    }
}

class JokeRemoteRepository () {

    var jokeRetrofitService = Retrofit.Builder()
        .baseUrl("https://api.icndb.com")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JokeRetrofitService::class.java)

    private var disposable = CompositeDisposable()

    fun requestList(callback: (ArrayList<Joke>) -> Unit) {
        Log.i("miky", "repository init")

        disposable.add(Observable.just("")
            .subscribeOn(Schedulers.io())
            .switchMap { jokeRetrofitService.getList().toObservable() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                if("success".equals(it.type)) {
                    Log.i("miky", "joke list size: ${it.value.size}")
                    callback(it.value)
                }
            }, {
                Log.e("miky", it.message ?: "error message null")
            })
        )
    }
}

interface JokeRetrofitService {
    @GET("jokes/random/20")
    fun getList(): Single<GetListResult>
}