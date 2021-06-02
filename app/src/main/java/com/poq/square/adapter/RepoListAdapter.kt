package com.poq.square.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.poq.square.databinding.SingleItemBinding
import com.poq.square.model.RepoListElement

class RepoListAdapter(val onClickListener: OnClickListener) : ListAdapter<RepoListElement, RepoListAdapter.RepoViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<RepoListElement>() {
        override fun areItemsTheSame(oldItem: RepoListElement, newItem: RepoListElement): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RepoListElement, newItem: RepoListElement): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class OnClickListener(val clickListener: (repoListElement: RepoListElement) -> Unit) {
        fun onClick(repoListElement: RepoListElement) = clickListener(repoListElement)
    }

    class RepoViewHolder(private var binding: SingleItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(repoListElement: RepoListElement) {
            binding.repo = repoListElement
            if (repoListElement.description == null) {
                binding.repoDescription.visibility = View.GONE
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListAdapter.RepoViewHolder {
        return RepoViewHolder(SingleItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RepoListAdapter.RepoViewHolder, position: Int) {
        val repoListElement = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(repoListElement)
        }
        holder.bind(repoListElement)
    }
}