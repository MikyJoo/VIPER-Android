package com.example.miky.viper.data

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

    private var jokeList: ArrayList<Joke>? = null

    companion object {
        private lateinit var sInstance: JokeRepository

        fun getInstance(): JokeRepository {
            if (!::sInstance.isInitialized) {
                sInstance = JokeRepository()
            }
            return sInstance
        }
    }

    fun requestList(result: (ArrayList<Joke>) -> Unit) {
        remoteSource.requestList {
            jokeList = it
            result(it)
        }
    }

    fun getJoke(position: Int): Joke? {
        return jokeList?.get(position)
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