package com.hexware.battleground.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

@Composable
fun WebRequests() {
    Text("You're looking at the web requests example now")

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