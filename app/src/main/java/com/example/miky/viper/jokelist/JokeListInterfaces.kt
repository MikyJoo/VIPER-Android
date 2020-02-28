package com.example.miky.viper.jokelist

import com.example.miky.viper.base.BaseViewInterface
import com.example.miky.viper.data.Joke

interface JokeListRouterInterface {
    var view: BaseViewInterface

    interface Creator {
        fun createModule(view: JokeListActivityInterface)
    }

    fun startJokeDetail(index: Int)
}

interface JokeListActivityInterface: BaseViewInterface {
    var presenter: JokeListPresenterInterface

    fun updateList(jokeList: ArrayList<Joke>)
}

interface JokeListPresenterInterface {
    var jokeList: ArrayList<Joke>

    fun onCreate()
    fun refresh()
    fun onClickItem(index: Int)
}

interface JokeListInteractorInterface {
    fun loadJokeList(result: (ArrayList<Joke>) -> Unit)
}