package com.hexware.battleground.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hexware.battleground.foundation.RetrofitInstance
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class WebRequestsViewModel : ViewModel() {
    private val client = OkHttpClient()

    /**
     * Wrapper around which scope to use when we want to
     * execute some asynchronous code.
     */
    private fun async(fn: suspend () -> Unit) {
        viewModelScope.launch { fn() }
    }

    /**
     * Make a simple web request using the OkHTTP library.
     * This is what retrofit uses internally anyway so it's
     * not really necessary but it's good to know how it
     * works on the underside. Hence the example here.
     */
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

    /**
     * Make a simple web request using the API we predefined
     * in retrofit (look in foundation.Api). This is a much nicer way
     * to do things compared to the above OkHTTP call.
     *
     * Given that the retrofit api is initialized once, very lazily,
     * we can call on it any number of times and always retrieve the
     * latest instance. This is handled in foundation.RetrofitInstance,
     * while the OkHTTP client is a simple variable here.
     */
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