package com.example.miky.mvvm.jokelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.miky.mvvm.R
import com.example.miky.mvvm.data.Joke

class JokeListAdapter(
    private var context: Context,
    private var jokeList: ArrayList<Joke>?,
    var itemClickListener: (View, Int) -> Unit): RecyclerView.Adapter<JokeListAdapter.JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.joke_list_item, parent, false)
        return JokeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return jokeList?.size ?: 0
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class JokeViewHolder(itemView: View): ViewHolder(itemView) {

        fun bind(position: Int) {
            jokeList?.let {
                var joke = it[position]
                itemView.findViewById<TextView>(R.id.id_text).text = joke.id.toString()
                itemView.findViewById<TextView>(R.id.joke_text).text = joke.joke
                itemView.setOnClickListener {
                    itemClickListener(it, position)
                }
            }
        }
    }
    
    fun setList(list:ArrayList<Joke>) {
        jokeList?.let {
            it.clear()
            it.addAll(list)
        } ?:let {
            jokeList = list
        }

        notifyDataSetChanged()
    }
}

