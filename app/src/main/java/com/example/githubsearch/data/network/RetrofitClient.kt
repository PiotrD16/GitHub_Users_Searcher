package com.example.githubsearch.data.network

import com.example.githubsearch.data.model.User
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object RetrofitClient {
    private const val BASE_URL: String = "https://api.github.com/"
    private val json = Json {

        // ignores fields that are not defined in our app
        ignoreUnknownKeys = true

        // protection from API errors such as null values
        coerceInputValues = true
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    val apiInterface: ApiInterface by lazy {retrofit.create(ApiInterface::class.java)}
}