package com.example.githubsearch.data.network

import com.example.githubsearch.data.model.GithubApiResponse
import com.example.githubsearch.data.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("search/users")
    suspend fun getUsers(@Query("q")name: String): GithubApiResponse
}