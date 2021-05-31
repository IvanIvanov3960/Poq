package com.poq.square

import retrofit2.Call
import retrofit2.http.GET

interface ApplicationInterface {
    @GET("/orgs/square/repos")
    fun getRepos(): Call<List<Any>>
}