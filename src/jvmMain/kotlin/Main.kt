// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState


@Composable
@Preview
fun App() {
    var count by remember { mutableStateOf(0) }
    MaterialTheme {

        Column(Modifier.fillMaxSize().background(Color.Gray), verticalArrangement = Arrangement.spacedBy(20.dp)) {

            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {

                Text(
                    "Avatar: O Caminho da Água",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline
                )
                Text("Duração: 3 h 12 min", fontSize = 18.sp)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Image(
                    painter = painterResource("Imagem_Avatar.jpg"),
                    contentDescription = "Avatar"
                )
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {

                    Text(
                        "Jake Sully vive com sua nova família na lua extrassolar Pandora. Uma vez que uma ameaça familiar retorna para terminar o que" +
                                "foi iniciado anteriormente, Jake deve trabalhar com Neytiri e o exército da raça Na'vi para proteger sua casa.",
                        fontSize = 17.sp
                    )
                    Text("Direção: James Cameron", fontSize = 18.sp)

                    if (count % 2 == 0 || count == 0) {
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                            onClick = { count++ }) {
                            Text("Favoritar")
                        }
                    } else {
                        ExtendedFloatingActionButton(onClick = { count++ },
                            text = { Text("Favoritado") },
                            icon = { Icon(Icons.Filled.Star, "") }
                        )
                    }
//               else  {
//                    Button(colors= ButtonDefaults.buttonColors(backgroundColor = Color.Green),onClick = { count++ }) {
//                        Text("Favoritado")
//                    }
//                }
                }

            }
            Text("Nota: 8/10  -  Ano: 2022", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Card(
                    backgroundColor = Color.LightGray,
                    border = BorderStroke(0.1.dp, color = Color.Black),
                    shape = CircleShape
                ) { Text("Ação") }
                Card(
                    backgroundColor = Color.LightGray,
                    border = BorderStroke(0.1.dp, color = Color.Black),
                    shape = CircleShape
                ) { Text("Aventura") }
                Card(
                    backgroundColor = Color.LightGray,
                    border = BorderStroke(0.1.dp, color = Color.Black),
                    shape = CircleShape
                ) { Text("Fantasia") }
            }
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

