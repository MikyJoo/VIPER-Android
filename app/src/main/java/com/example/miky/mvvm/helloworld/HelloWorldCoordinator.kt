package com.example.miky.mvvm.helloworld

class HelloWorldCoordinator(override var view: HelloWorldMainActivityInterface): HelloWorldMainCoodinatorInterface {

    var viewModel: HelloWorldMainViewModelInterface = HelloWorldViewModel(this)

    init {
        view.viewModel = viewModel
    }

    companion object: HelloWorldMainCoodinatorInterface.Creator {
        override fun createModule(view: HelloWorldMainActivityInterface) {
            HelloWorldCoordinator(view)
        }
    }
}