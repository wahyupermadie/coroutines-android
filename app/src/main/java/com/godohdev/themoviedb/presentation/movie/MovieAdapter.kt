package com.godohdev.themoviedb.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.godohdev.themoviedb.R
import com.godohdev.themoviedb.data.model.MoviesResult
import com.godohdev.themoviedb.databinding.ItemMovieBinding

/**
 *
 * Created by Wahyu Permadi on 2020-02-21.
 * Android Engineer
 *
 **/

class MovieAdapter (
    private val listener: (MoviesResult) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    private var movies : MutableList<MoviesResult> = mutableListOf()

    fun addData(list: MutableList<MoviesResult>){
        movies = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movies?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resultsItem : MoviesResult? =  movies?.get(position)
        holder.binding.movie = resultsItem

        holder.bindItem(resultsItem, listener)
    }

    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(resultsItem: MoviesResult?, listener: (MoviesResult) -> Unit) {
            itemView.setOnClickListener {
                resultsItem?.let { it1 -> listener(it1) }
            }
        }
    }
}