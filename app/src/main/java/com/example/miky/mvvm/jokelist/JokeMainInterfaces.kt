package com.example.miky.mvvm.jokelist

import androidx.lifecycle.MutableLiveData
import com.example.miky.mvvm.data.Joke

interface HelloWorldMainCoodinatorInterface {
    var view: HelloWorldMainActivityInterface

    interface Creator {
        fun createModule(view: HelloWorldMainActivityInterface)
    }
}

interface HelloWorldMainActivityInterface {
    var viewModel: HelloWorldMainViewModelInterface
}

interface HelloWorldMainViewModelInterface {
    var liveJokeList: MutableLiveData<ArrayList<Joke>>

    fun onCreate()
    fun refresh()
}