package com.hexware.battleground.foundation

import com.hexware.battleground.foundation.models.Todo
import retrofit2.Response
import retrofit2.http.GET

/**
 * Generate a Retrofit interface api definition so we
 * have incredibly structured access to our api.
 *
 * This is just a simple api wrapper for the popular
 * json placeholder todo api.
 *
 * The models are a 1:1 representation of whatever the
 * endpoints return (check foundation.models.Todo for more details)
 */
interface TodoApi {

    @GET("/todos")
    suspend fun getTodos(): Response<List<Todo>>
}