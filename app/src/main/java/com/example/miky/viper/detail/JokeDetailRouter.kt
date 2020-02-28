package com.example.miky.viper.detail

import com.example.miky.viper.base.BaseViewInterface

class JokeDetailRouter private constructor(override var view: BaseViewInterface): JokeDetailRouterInterface {

    companion object: JokeDetailRouterInterface.Creator {
        override fun createModule(view: JokeDetailActivityInterface) {
            val router = JokeDetailRouter(view)
            val interactor = JokeDetailInteractor()
            val presenter = JokeDetailPresenter(view, router, interactor)
            
            view.presenter = presenter
        }
    }
}