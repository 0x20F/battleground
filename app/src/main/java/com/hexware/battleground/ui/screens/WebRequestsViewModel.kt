package com.hexware.battleground.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hexware.battleground.foundation.RetrofitInstance
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class WebRequestsViewModel : ViewModel() {
    private val client = OkHttpClient()

    private fun async(fn: suspend () -> Unit) {
        viewModelScope.launch { fn() }
    }

    fun simpleCallOkHttp() {
        async {
            val request = Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build()

            client.newCall(request).enqueue(object: Callback {
                override fun onFailure(call: Call, e: IOException) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        if (!it.isSuccessful) throw IOException("Unexpected code $it")

                        for ((name, value) in it.headers) {
                            println("$name: $value")
                        }

                        println(it.body!!.string())
                    }
                }
            })
        }
    }

    fun simpleCallRetrofit() {
        async {
            val todos = RetrofitInstance.api.getTodos()

            if (!todos.isSuccessful) {
                println("Couldn't fetch todos for some reason")
            }

            println(todos.body()!!)
        }
    }
}