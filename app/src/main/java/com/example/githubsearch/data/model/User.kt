package com.example.githubsearch.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// It is a single user
@Serializable
data class User (
    val id: Int, var login: String, @SerialName("avatar_url") var avatarUrl: String
)

// Here we have a response from the API
@Serializable
data class GithubApiResponse (@SerialName("items") var githubApiUsers: List<User>)