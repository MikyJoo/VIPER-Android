package com.example.miky.mvvm.jokelist

import android.content.Intent
import com.example.miky.mvvm.detail.JokeDetailActivity

class JokeListCoordinator private constructor(override var view: JokeListActivityInterface):
    JokeListCoodinatorInterface {

    var viewModel: JokeListViewModelInterface = JokeListViewModel(this)

    init {
        view.viewModel = viewModel
    }

    companion object: JokeListCoodinatorInterface.Creator {
        override fun createModule(view: JokeListActivityInterface) {
            JokeListCoordinator(view)
        }
    }

    override fun startJokeDetail(index: Int) {
        var intent = Intent(view.getContext(), JokeDetailActivity::class.java)
        intent.putExtra("index", index)
        view.getContext().startActivity(intent)
    }
}