package com.hexware.battleground.screens

import com.hexware.battleground.ui.screens.WebRequestsViewModel
import org.junit.Test

class WebRequests {
    @Test
    fun webRequestOkHttp() {
        val vm = WebRequestsViewModel()
        vm.simpleCallOkHttp()
    }

    @Test
    fun webRequestRetrofit() {
        val vm = WebRequestsViewModel()
        vm.simpleCallRetrofit()
    }
}