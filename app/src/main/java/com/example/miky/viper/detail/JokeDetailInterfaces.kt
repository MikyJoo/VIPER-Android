package com.example.miky.viper.detail

import androidx.lifecycle.LiveData
import com.example.miky.viper.base.BaseViewInterface
import com.example.miky.viper.data.Joke

interface JokeDetailRouterInterface {
    var view: BaseViewInterface

    interface Creator {
        fun createModule(view: JokeDetailActivityInterface)
    }
}

interface JokeDetailActivityInterface: BaseViewInterface {
    var presenter: JokeDetailPresenterInterface

    fun update(joke: Joke)
}

interface JokeDetailPresenterInterface {

    var jokeItem: Joke?

    fun onCreate()
    fun setIndex(index: Int)
    fun refreshTest()
}

interface JokeDetailInteractorInterface {
    fun getJoke(index: Int): Joke?
}