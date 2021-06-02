package com.poq.square.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.poq.square.model.RepoListElement

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<RepoListElement>?) {
    val adapter = recyclerView.adapter as RepoListAdapter
    adapter.submitList(data)
}