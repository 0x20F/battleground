package com.hexware.battleground.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.hexware.battleground.foundation.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

@Composable
fun WebRequests() {
    Text("You're looking at the web requests example now")

    simpleCallOkHTTP()
    simpleCallRetrofit()
}

fun simpleCallOkHTTP() {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://publicobject.com/helloworld.txt")
        .build()

    client.newCall(request).execute().use {
        if (!it.isSuccessful) throw IOException("Unexpected code $it")

        for ((name, value) in it.headers) {
            println("$name: $value")
        }

        println(it.body!!.string())
    }
}

fun simpleCallRetrofit() {
    val scope = MainScope()

    scope.launch {
        val todos = RetrofitInstance.api.getTodos()

        if (!todos.isSuccessful) {
            println("Couldn't fetch todos for some reason")
        }

        println(todos.body()!!)
    }
}