package com.example.miky.mvvm.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.miky.mvvm.R
import com.example.miky.mvvm.databinding.ActivityJokeDetailBinding

class JokeDetailActivity : AppCompatActivity(), JokeDetailActivityInterface {

    override lateinit var viewModel: JokeDetailViewModelInterface
    private lateinit var binding: ActivityJokeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JokeDetailCoordinator.createModule(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_joke_detail)

        var position = intent.getIntExtra("index", 0)
        viewModel.setIndex(position)

        viewModel.liveJokeItem.observe(this, Observer {
            binding.idText.text = it.id.toString()
            binding.jokeText.text = it.joke
        })

        binding.jokeText.setOnClickListener {
            viewModel.refreshTest()
        }

        viewModel.onCreate()
    }


}
