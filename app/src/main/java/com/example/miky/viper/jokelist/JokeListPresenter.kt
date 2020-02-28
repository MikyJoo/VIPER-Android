package com.example.miky.viper.jokelist

import com.example.miky.viper.data.Joke
import com.example.miky.viper.data.JokeRepository

class JokeListPresenter(
    var view: JokeListActivityInterface,
    var router: JokeListRouterInterface,
    var interactor: JokeListInteractorInterface): JokeListPresenterInterface {

    override lateinit var jokeList: ArrayList<Joke>

    override fun onCreate() {
        refresh()
    }

    override fun refresh() {
        interactor.loadJokeList {
            jokeList = it
            view.updateList(jokeList)
        }
    }

    override fun onClickItem(index: Int) {
        router.startJokeDetail(index)
    }
}