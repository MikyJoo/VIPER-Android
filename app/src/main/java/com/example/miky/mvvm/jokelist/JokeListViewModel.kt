package com.example.miky.mvvm.jokelist

import com.example.miky.mvvm.data.JokeRepository

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