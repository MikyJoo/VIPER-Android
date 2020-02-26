package com.example.miky.mvvm.helloworldmain

interface HelloWorldMainCoodinatorInterface {
    fun createModel()
}

interface HelloWorldMainActivityInterface {
    var viewModel: HelloWorldMainViewModelInterface
}

interface HelloWorldMainViewModelInterface {
    fun onCreate()
    fun refresh()
}