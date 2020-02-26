package com.example.miky.mvvm.jokelist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miky.mvvm.R
import com.example.miky.mvvm.databinding.ActivityJokeMainBinding

class JokeMainActivity : AppCompatActivity(), HelloWorldMainActivityInterface {

    override lateinit var viewModel: HelloWorldMainViewModelInterface
    private lateinit var binding: ActivityJokeMainBinding

    private var layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    private lateinit var adapter: JokeMainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JokeMainCoordinator.createModule(
            this
        )

        binding = DataBindingUtil.setContentView(this, R.layout.activity_joke_main)

        binding.mainSl.setOnRefreshListener {
            viewModel.refresh()
        }

        binding.jokeList.layoutManager = layoutManager
        adapter = JokeMainAdapter(this, null, onClickListItem)
        binding.jokeList.adapter = adapter

        viewModel.liveJokeList.observe(this, Observer {
            Log.i("miky", "observe~!!!! ${it.size}")
            binding.mainSl.isRefreshing = false
            adapter.setList(it)
        })

        viewModel.onCreate()
    }

    val onClickListItem = fun(view: View, position: Int) {
//        mainViewModel.onClickItem(position)
//        var intent = Intent(this, DetailActivity::class.java)
//        intent.putExtra("position", position)
//        startActivity(intent)
    }

}
