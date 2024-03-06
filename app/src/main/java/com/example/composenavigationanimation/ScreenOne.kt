package com.example.composenavigationanimation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ScreenOne( onClick : () -> Unit = {}) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = { onClick.invoke() }) {
            Text("click me")
        }
    }

}

@Composable
fun ScreenTwo(onClick: () -> Unit = {}){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("this is the screen number 2")
        Button(onClick = { onClick.invoke() }) {
            Text("click me for back")
        }
    }
}