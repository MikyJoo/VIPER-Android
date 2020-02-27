package com.example.miky.mvvm.jokelist

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.miky.mvvm.data.Joke

interface JokeListCoodinatorInterface {
    var view: JokeListActivityInterface

    interface Creator {
        fun createModule(view: JokeListActivityInterface)
    }

    fun startJokeDetail(index: Int)
}

interface JokeListActivityInterface {
    var viewModel: JokeListViewModelInterface
    fun getContext(): Context
}

interface JokeListViewModelInterface {
    var liveJokeList: MutableLiveData<ArrayList<Joke>>

    fun onCreate()
    fun refresh()
    fun onClickItem(index: Int)
}