package com.example.miky.mvvm.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.miky.mvvm.data.Joke
import com.example.miky.mvvm.data.JokeRepository

class JokeDetailViewModel(var coordinator: JokeDetailCoodinatorInterface): JokeDetailViewModelInterface {

    var repository = JokeRepository.getInstance()

    override lateinit var liveJokeItem: LiveData<Joke>

    override fun onCreate() {
//        refresh()
    }

    override fun setIndex(index: Int) {
        liveJokeItem = Transformations.map(repository.jokeList) {
            it[index]
        }
    }

    override fun refreshTest() {
        repository.requestList()
    }
}