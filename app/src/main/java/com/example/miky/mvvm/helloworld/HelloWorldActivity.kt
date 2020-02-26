package com.example.miky.mvvm.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.miky.mvvm.R
import com.example.miky.mvvm.databinding.ActivityHelloworldBinding

class HelloWorldActivity : AppCompatActivity(), HelloWorldMainActivityInterface {

    override lateinit var viewModel: HelloWorldMainViewModelInterface

    private lateinit var binding: ActivityHelloworldBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HelloWorldCoordinator(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_helloworld)

        binding.mainSl.setOnRefreshListener {
            viewModel.refresh()
        }

        viewModel.liveTextData.observe(this, Observer {
            binding.mainText.text = it
        })

        viewModel.onCreate()
    }
}
