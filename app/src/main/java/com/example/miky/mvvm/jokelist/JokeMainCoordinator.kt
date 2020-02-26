package com.example.miky.mvvm.jokelist

class JokeMainCoordinator(override var view: HelloWorldMainActivityInterface): HelloWorldMainCoodinatorInterface {

    var viewModel: HelloWorldMainViewModelInterface = JokeMainViewModel(this)

    init {
        view.viewModel = viewModel
    }

    companion object: HelloWorldMainCoodinatorInterface.Creator {
        override fun createModule(view: HelloWorldMainActivityInterface) {
            JokeMainCoordinator(view)
        }
    }
}