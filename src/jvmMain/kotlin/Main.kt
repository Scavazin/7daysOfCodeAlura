// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.

import HttpClient.MovieWebClient
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import extensions.MovieItem
import models.Movie


@Composable
@Preview
fun App() {
    val imagens:  Map<Int,Map<Char,String>> = mapOf(
        Pair( 1 , mapOf('t' to "Avatar o caminho das águas" , 'i' to "https://jovemnerd.com.br/wp-content/uploads/2022/11/image002__5x00q89b.jpg" , 'n' to "7.9" , 'a' to "2022")),
        Pair( 2 , mapOf('t' to "The Dark Knight" , 'i' to "https://upload.wikimedia.org/wikipedia/pt/d/d1/The_Dark_Knight.jpg" , 'n' to "7.9" , 'a' to "2022")),
        Pair( 3 , mapOf('t' to "Avengers: Endgame" , 'i' to "https://upload.wikimedia.org/wikipedia/pt/9/9b/Avengers_Endgame.jpg" , 'n' to "7.9" , 'a' to "2022")),
    )

    MaterialTheme(colors = darkColors()) {
        Surface {
            Box(modifier = Modifier.fillMaxSize()) {

                val movies = listOf(
                    Movie(titulo = imagens[1]?.getValue('t'), url_imagem = imagens[1]!!.getValue('i'), nota = imagens[1]?.getValue('n')?.toDouble() , ano = imagens[1]?.getValue('a')?.toInt()),
                    Movie(titulo = imagens[2]?.getValue('t'), url_imagem = imagens[2]?.getValue('i'), nota = imagens[2]?.getValue('n')?.toDouble() , ano = imagens[2]?.getValue('a')?.toInt()),
                    Movie(titulo = imagens[3]?.getValue('t'), url_imagem = imagens[3]?.getValue('i'), nota = imagens[3]?.getValue('n')?.toDouble() , ano = imagens[3]?.getValue('a')?.toInt()),
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

fun main() = application {
    MovieWebClient().findTop250Movies()
    Window(
        onCloseRequest = ::exitApplication,
        title = "IMDB",
        state = rememberWindowState(width = 800.dp, height = 800.dp)
    ) {
        App()
    }
}