package extensions

import models.Movie
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import loadImageBitmap

@Composable
fun MovieItem(movie: Movie) {
    Column(
        modifier = Modifier.padding(16.dp).width(200.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            bitmap = movie.url_imagem!!.loadImageBitmap(),
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
        movie.titulo!!,
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
}