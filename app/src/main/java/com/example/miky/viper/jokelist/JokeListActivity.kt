package com.example.miky.viper.jokelist

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miky.viper.R
import com.example.miky.viper.data.Joke
import com.example.miky.viper.databinding.ActivityJokeListBinding

class JokeListActivity : AppCompatActivity(), JokeListActivityInterface {

    override lateinit var presenter: JokeListPresenterInterface
    private lateinit var binding: ActivityJokeListBinding

    private var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private lateinit var adapter: JokeListAdapter

    override val viewContext: Context
        get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JokeListRouter.createModule(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_joke_list)

        binding.mainSl.setOnRefreshListener {
            presenter.refresh()
        }
        binding.mainSl.isRefreshing = true

        binding.jokeList.layoutManager = layoutManager
        adapter = JokeListAdapter(this, null, onClickListItem)
        binding.jokeList.adapter = adapter

        presenter.onCreate()
    }

    val onClickListItem = fun(view: View, index: Int) {
        presenter.onClickItem(index)
    }

    override fun updateList(jokeList: ArrayList<Joke>) {
        binding.mainSl.isRefreshing = false
        adapter.setList(jokeList)
    }
}
