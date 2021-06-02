package com.poq.square.listRepos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poq.square.model.RepoListElement
import com.poq.square.services.ApplicationApi
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoListViewModel : ViewModel() {

    val _repos: MutableLiveData<List<RepoListElement>> = MutableLiveData<List<RepoListElement>>()

    val repos: LiveData<List<RepoListElement>>
        get() = _repos

    init {
        getRepos()
    }

    private fun getRepos() {
        viewModelScope.launch {
            ApplicationApi.retrofitService.getRepos().enqueue(object:
                Callback<List<RepoListElement>> {
                override fun onResponse(call: Call<List<RepoListElement>>, response: Response<List<RepoListElement>>) {
                    val s = response.body()
                    if (response.isSuccessful) {
                        _repos.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<RepoListElement>>, t: Throwable) {
                    t.printStackTrace()
                }

            })
        }
    }
}