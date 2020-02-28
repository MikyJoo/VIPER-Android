package com.example.miky.viper.detail

import androidx.lifecycle.LiveData
import com.example.miky.viper.data.Joke

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