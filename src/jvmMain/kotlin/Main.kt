// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    val image1 = "https://jovemnerd.com.br/wp-content/uploads/2022/11/image002__5x00q89b.jpg"
    val image2 = "https://upload.wikimedia.org/wikipedia/pt/d/d1/The_Dark_Knight.jpg"
    val image3 = "https://upload.wikimedia.org/wikipedia/pt/9/9b/Avengers_Endgame.jpg"


    // var count by remember { mutableStateOf(0) }

    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {

                val movies = listOf(
                    Movie(titulo = "Avatar o caminho das águas", url_imagem = image1, nota = 7.9, ano = 2022),
                    Movie(titulo = "The Dark Knight", url_imagem = image2, nota = 9.0, ano = 2008),
                    Movie(titulo = "Avengers: Endgame", url_imagem = image3, nota = 8.4, ano = 2019)
                )
                LazyColumn {
                    items(movies) { movie ->
                        MovieItem(movie)
                    }
                }
            }
        }
    }
}


@Composable
private fun MovieItem(movie: Movie) {
    Column(
        modifier = Modifier.padding(16.dp).width(200.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            bitmap = movie.url_imagem.loadImageBitmap(),
            contentDescription = "capa do filme",
            modifier = Modifier.fillMaxSize()
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp
            ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Filled.Star, "", tint = Color.Yellow)
                Text("${movie.nota}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Text("${movie.ano}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
    Text(
        movie.titulo,
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )

//                    if (count == 0) {
//                        Button(
//                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
//                            onClick = { count++ }) {
//                            Text("Favoritar")
//                        }
//                    } else {
//                        ExtendedFloatingActionButton(
//                            onClick = { count-- },
//                            text = { Text("Favoritado") },
//                            icon = {
//                                Icon(Icons.Filled.Star, "")
//                            }
//                        )
//                    }

//                    Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
//                        Card(
//                            backgroundColor = Color.DarkGray,
//                            border = BorderStroke(0.1.dp, color = Color.White),
//                            shape = CircleShape
//                        ) { Text("Ação") }
//                        Card(
//                            backgroundColor = Color.DarkGray,
//                            border = BorderStroke(0.1.dp, color = Color.White),
//                            shape = CircleShape
//                        ) { Text("Aventura") }
//                        Card(
//                            backgroundColor = Color.DarkGray,
//                            border = BorderStroke(0.1.dp, color = Color.White),
//                            shape = CircleShape
//                        ) { Text("Fantasia") }
//                    }
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