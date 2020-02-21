package com.godohdev.themoviedb.presentation.detail

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.godohdev.themoviedb.R
import com.godohdev.themoviedb.data.model.ReviewResult
import com.godohdev.themoviedb.databinding.ItemReviewBinding

/**
 *
 * Created by Wahyu Permadi on 2020-02-22.
 * Android Engineer
 *
 **/

class ReviewAdapter : RecyclerView.Adapter<ReviewAdapter.ViewHolder>(){
    private var reviews : MutableList<ReviewResult>? = mutableListOf()

    fun addData(list: MutableList<ReviewResult>){
        reviews = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemReviewBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_review,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return reviews?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val resultsItem : ReviewResult? =  reviews?.get(position)
        holder.binding.review = resultsItem
        holder.binding.tvContent.movementMethod = ScrollingMovementMethod()
        holder.bindItem(resultsItem)
    }

    class ViewHolder(val binding: ItemReviewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem(resultsItem: ReviewResult?) {

        }
    }
}