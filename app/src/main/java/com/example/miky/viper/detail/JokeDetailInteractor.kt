package com.example.miky.viper.detail

import com.example.miky.viper.data.Joke
import com.example.miky.viper.data.JokeRepository

class JokeDetailInteractor : JokeDetailInteractorInterface {
    override fun getJoke(index: Int): Joke? {
        return JokeRepository.getInstance().getJoke(index)
    }
}