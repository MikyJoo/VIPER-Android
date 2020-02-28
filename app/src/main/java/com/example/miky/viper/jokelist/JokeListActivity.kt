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
import com.example.miky.viper.databinding.ActivityJokeListBinding

class JokeListActivity : AppCompatActivity(), JokeListActivityInterface {

    override lateinit var viewModel: JokeListViewModelInterface
    private lateinit var binding: ActivityJokeListBinding

    private var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private lateinit var adapter: JokeListAdapter

    override fun getContext(): Context {
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JokeListCoordinator.createModule(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_joke_list)

        binding.mainSl.setOnRefreshListener {
            viewModel.refresh()
        }
        binding.mainSl.isRefreshing = true

        binding.jokeList.layoutManager = layoutManager
        adapter = JokeListAdapter(this, null, onClickListItem)
        binding.jokeList.adapter = adapter

        viewModel.liveJokeList.observe(this, Observer {
            Log.i("miky", "observe~!!!! ${it.size}")
            binding.mainSl.isRefreshing = false
            adapter.setList(it)
        })

        viewModel.onCreate()
    }

    val onClickListItem = fun(view: View, index: Int) {
        viewModel.onClickItem(index)
    }
}
