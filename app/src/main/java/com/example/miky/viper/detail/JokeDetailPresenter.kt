package com.example.miky.viper.detail

import androidx.lifecycle.LiveData
import com.example.miky.viper.data.Joke
import com.example.miky.viper.data.JokeRepository

class JokeDetailPresenter(
    var view: JokeDetailActivityInterface,
    var router: JokeDetailRouterInterface,
    var interactor: JokeDetailInteractorInterface): JokeDetailPresenterInterface {

    override var jokeItem: Joke? = null

    override fun onCreate() {
        jokeItem?.let {
            view.update(it)
        }
    }

    override fun setIndex(index: Int) {
        jokeItem = interactor.getJoke(index)
    }

    override fun refreshTest() {
    }
}