package com.example.miky.mvvm.helloworld

import androidx.lifecycle.MutableLiveData

interface HelloWorldMainCoodinatorInterface {
    var view: HelloWorldMainActivityInterface

    interface Creator {
        fun createModule(view: HelloWorldMainActivityInterface)
    }
}

interface HelloWorldMainActivityInterface {
    var viewModel: HelloWorldMainViewModelInterface
}

interface HelloWorldMainViewModelInterface {
    var liveTextData: MutableLiveData<String>

    fun onCreate()
    fun refresh()
}