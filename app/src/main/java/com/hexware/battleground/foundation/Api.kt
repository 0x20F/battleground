package com.hexware.battleground.foundation

import com.hexware.battleground.foundation.models.Todo
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {

    @GET("/todos")
    suspend fun getTodos(): Response<List<Todo>>
}