package com.hexware.battleground.ui.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.hexware.battleground.concerns.Container
import com.hexware.battleground.concerns.Screen

@Composable
@Preview
fun StartScreen() {
    Button(onClick = { Container.navigate(Screen.WebRequests.route) }) {
        Text(text = "Web Requests Module")
    }
}