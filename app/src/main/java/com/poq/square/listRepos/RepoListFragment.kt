package com.poq.square.listRepos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.poq.square.R
import com.poq.square.adapter.RepoListAdapter
import com.poq.square.databinding.RepoListFragmentBinding
import com.poq.square.model.RepoListElement

class RepoListFragment : Fragment() {

    private val viewModel: RepoListViewModel by lazy {
        ViewModelProvider(this).get(RepoListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = RepoListFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.repos = viewModel

            binding.recyclerView.adapter = RepoListAdapter(RepoListAdapter.OnClickListener{
                //TODO implementation if there will be any app interaction
            })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}