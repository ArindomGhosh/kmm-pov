package com.example.kmmnews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun App(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        GreetingView(Greeting().greet())
    }
}
@Composable
fun GreetingView(text: String) {
    Column(
        horizontalAlignment =  Alignment.CenterHorizontally
    ) {
        Text(text = text)
        Button(onClick = {

        }){
            Text("Click Here")
        }
    }

}