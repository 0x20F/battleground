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
fun WebRequests(vm: WebRequestsViewModel) {
    Text("You're looking at the web requests example now")

    vm.simpleCallRetrofit()
    vm.simpleCallOkHttp()
}