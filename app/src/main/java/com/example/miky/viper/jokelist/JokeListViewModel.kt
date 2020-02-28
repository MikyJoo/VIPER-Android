package com.example.miky.viper.jokelist

import com.example.miky.viper.data.JokeRepository

class JokeListViewModel(var coordinator: JokeListCoodinatorInterface): JokeListViewModelInterface {

    var repository = JokeRepository.getInstance()

    override var liveJokeList = repository.getLiveDataForList()

    override fun onCreate() {
//        refresh()
    }

    override fun refresh() {
        repository.requestList()
    }

    override fun onClickItem(index: Int) {
        coordinator.startJokeDetail(index)
    }
}