package com.poq.square

import com.poq.square.model.RepoListElement
import retrofit2.Call
import retrofit2.http.GET

interface ApplicationInterface {
    @GET("/orgs/square/repos")
    fun getRepos(): Call<List<RepoListElement>>
}