package com.example.miky.viper.detail

class JokeDetailCoordinator private constructor(override var view: JokeDetailActivityInterface):
    JokeDetailCoodinatorInterface {

    var viewModel: JokeDetailViewModelInterface = JokeDetailViewModel(this)

    init {
        view.viewModel = viewModel
    }

    companion object: JokeDetailCoodinatorInterface.Creator {
        override fun createModule(view: JokeDetailActivityInterface) {
            JokeDetailCoordinator(view)
        }
    }
}