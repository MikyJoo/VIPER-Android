package com.example.miky.viper.detail

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.miky.viper.R
import com.example.miky.viper.data.Joke
import com.example.miky.viper.databinding.ActivityJokeDetailBinding

class JokeDetailActivity : AppCompatActivity(), JokeDetailActivityInterface {

    override lateinit var presenter: JokeDetailPresenterInterface
    private lateinit var binding: ActivityJokeDetailBinding

    override val viewContext: Context
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JokeDetailRouter.createModule(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_joke_detail)

        var position = intent.getIntExtra("index", 0)
        presenter.setIndex(position)

        presenter.onCreate()
    }

    override fun update(joke: Joke) {
        binding.idText.text = joke.id.toString()
        binding.jokeText.text = joke.joke
    }
}
