package com.example.githubsearch.data.repository

import android.util.Log
import com.example.githubsearch.data.model.User
import com.example.githubsearch.data.network.ApiInterface

class UserRepository (private val apiInterface: ApiInterface) {

    suspend fun searchUser(query: String): List<User> {
        try {
            val response = apiInterface.getUsers(query)
            return response.githubApiUsers
        } catch (e: Exception){
            Log.e("UserRepository", "An error occurred: $e")
        }
        return emptyList()
    }
}