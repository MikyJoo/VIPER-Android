package com.example.miky.viper.jokelist

import com.example.miky.viper.data.Joke
import com.example.miky.viper.data.JokeRepository

class JokeListInteractor: JokeListInteractorInterface {
    override fun loadJokeList(result: (ArrayList<Joke>) -> Unit) {
        JokeRepository.getInstance().requestList(result)
    }
}