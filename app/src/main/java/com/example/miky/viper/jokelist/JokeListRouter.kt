package com.example.miky.viper.jokelist

import android.content.Intent
import com.example.miky.viper.base.BaseViewInterface
import com.example.miky.viper.detail.JokeDetailActivity

class JokeListRouter private constructor(override var view: BaseViewInterface): JokeListRouterInterface {

    companion object: JokeListRouterInterface.Creator {
        override fun createModule(view: JokeListActivityInterface) {
            val router = JokeListRouter(view)
            val interactor = JokeListInteractor()
            val presenter = JokeListPresenter(view, router, interactor)

            view.presenter = presenter
        }
    }

    override fun startJokeDetail(index: Int) {
        var intent = Intent(view.viewContext, JokeDetailActivity::class.java)
        intent.putExtra("index", index)
        view.viewContext.startActivity(intent)
    }
}