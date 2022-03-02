package com.hexware.battleground.foundation

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton container of the retrofit API interface
 * so we can easily access any of our fancy placeholder
 * TODOs endpoints.
 *
 * This is where retrofit receives the base URL it should use
 * for its API, as well as the converter factory it should use
 * for serialization and deserialization.
 */
object RetrofitInstance {

    val api: TodoApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoApi::class.java)
    }
}