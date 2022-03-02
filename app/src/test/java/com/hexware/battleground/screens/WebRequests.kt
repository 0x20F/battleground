package com.hexware.battleground.screens

import com.hexware.battleground.ui.screens.simpleCallOkHTTP
import com.hexware.battleground.ui.screens.simpleCallRetrofit
import org.junit.Test

class WebRequests {
    @Test
    fun webRequestOkHttp() {
        simpleCallOkHTTP()
    }

    @Test
    fun webRequestRetrofit() {
        simpleCallRetrofit()
    }
}