// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, beauty World!") }
    var cont by remember { mutableStateOf(0) }
    MaterialTheme {

        Column (Modifier.fillMaxSize(),verticalArrangement = Arrangement.spacedBy(5.dp)){
            Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {
                cont++
            }) {
                Text(if(cont==0) text else "Hello, Desktop!$cont")
            }
            Button(modifier = Modifier.align(Alignment.CenterHorizontally), onClick = {
                cont = 0
            }) { Text("Reset") }
        }

    }

}

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "IMDB",
        state = rememberWindowState(width = 300.dp, height = 300.dp)
    ) {
        App()
    }
}
