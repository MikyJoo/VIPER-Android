package com.example.miky.mvvm.jokelist

import androidx.lifecycle.MutableLiveData
import com.example.miky.mvvm.data.JokeRepository

class JokeMainViewModel(var coordinator: HelloWorldMainCoodinatorInterface): HelloWorldMainViewModelInterface {

    var repository = JokeRepository.getInstance()

    override var liveJokeList = repository.getLiveDataForList()

    override fun onCreate() {
//        refresh()
    }

    override fun refresh() {
        repository.requestList()
    }
}