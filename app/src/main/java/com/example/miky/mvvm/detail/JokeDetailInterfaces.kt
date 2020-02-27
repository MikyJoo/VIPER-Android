package com.example.miky.mvvm.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.miky.mvvm.data.Joke

interface JokeDetailCoodinatorInterface {
    var view: JokeDetailActivityInterface

    interface Creator {
        fun createModule(view: JokeDetailActivityInterface)
    }
}

interface JokeDetailActivityInterface {
    var viewModel: JokeDetailViewModelInterface
}

interface JokeDetailViewModelInterface {

    var liveJokeItem: LiveData<Joke>

    fun onCreate()
    fun setIndex(index: Int)
    fun refreshTest()
}