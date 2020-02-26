package com.example.miky.mvvm.helloworld

import androidx.lifecycle.MutableLiveData

class HelloWorldViewModel(var coordinator: HelloWorldMainCoodinatorInterface): HelloWorldMainViewModelInterface {

    override var liveTextData = MutableLiveData<String>()

    override fun onCreate() {
        refresh()
    }

    override fun refresh() {
        var text = ""

        for (x in 0 until (1..10).random()) {
            text = text + "Hello World~!\n"
        }

        liveTextData.postValue(text)
    }
}