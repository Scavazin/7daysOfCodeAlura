// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    val image = "https://jovemnerd.com.br/wp-content/uploads/2022/11/image002__5x00q89b.jpg"

//    val text by remember {
//        mutableStateOf(
//            "Jake Sully vive com sua nova família na lua extrassolar Pandora. " +
//                    "Uma vez que uma ameaça familiar retorna para terminar o que foi iniciado anteriormente, " +
//                    "Jake deve trabalhar com Neytiri e o exército da raça Na'vi para proteger sua casa."
//        )
//    }

    var count by remember { mutableStateOf(0) }

    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.size(height = 700.dp, width = 300.dp)) {
                Column(
                    modifier = Modifier.padding(15.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        bitmap = image.loadImageBitmap(),
                        contentDescription = "capa do filme",
                        modifier = Modifier.height(400.dp)
                    )
                    Row {
                        Icon(imageVector = Icons.Filled.Star, "", tint = Color.Yellow)
                        Row(horizontalArrangement = Arrangement.spacedBy(175.dp)) {
                            Text("7.9", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text("2022", fontSize = 18.sp, fontWeight = FontWeight.Bold)

                        }
                    }
                    Text(
                        "Avatar: O Caminho da Água",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )

//                    Text(
//                        "Duração: 3 h 12 min",
//                        fontSize = 15.sp
//                    )


//                            Text(
//                                text,
//                                fontSize = 16.sp
//                            )
//                            Text("Direção: James Cameron", fontSize = 16.sp)

                    if (count == 0) {
                        Button(
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                            onClick = { count++ }) {
                            Text("Favoritar")
                        }
                    } else {
                        ExtendedFloatingActionButton(
                            onClick = { count-- },
                            text = { Text("Favoritado") },
                            icon = {
                                Icon(Icons.Filled.Star, "")
                            }
                        )
                    }


                    Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                        Card(
                            backgroundColor = Color.DarkGray,
                            border = BorderStroke(0.1.dp, color = Color.White),
                            shape = CircleShape
                        ) { Text("Ação") }
                        Card(
                            backgroundColor = Color.DarkGray,
                            border = BorderStroke(0.1.dp, color = Color.White),
                            shape = CircleShape
                        ) { Text("Aventura") }
                        Card(
                            backgroundColor = Color.DarkGray,
                            border = BorderStroke(0.1.dp, color = Color.White),
                            shape = CircleShape
                        ) { Text("Fantasia") }
                    }
                }
            }
        }
    }
}

fun main() = application {

    Window(
        onCloseRequest = ::exitApplication,
        title = "IMDB",
        state = rememberWindowState(width = 800.dp, height = 800.dp)
    ) {
        App()
    }
}