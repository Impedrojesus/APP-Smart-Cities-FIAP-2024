package br.com.fiap.trainertrack.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.trainertrack.R

data class Trainer(
    val name: String,
    val function: String,
    val image: Painter
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TrainerScreen(navController: NavController) {
    var search by remember { mutableStateOf("") }
    val trainers = listOf(
        Trainer("Robson", "Futebol", painterResource(id = R.drawable.robson)),
        Trainer("Lara", "Natação", painterResource(id = R.drawable.lara)),
        Trainer("Rafael", "Crossfit", painterResource(id = R.drawable.rafael)),
        Trainer("Carlos", "Corrida", painterResource(id = R.drawable.carlos)),
        Trainer("Lara", "Natação", painterResource(id = R.drawable.lara)),
        Trainer("Carlos", "Corrida", painterResource(id = R.drawable.carlos)),
        Trainer("Robson", "Futebol", painterResource(id = R.drawable.robson)),
        Trainer("Rafael", "Crossfit", painterResource(id = R.drawable.rafael)),
        Trainer("Lara", "Natação", painterResource(id = R.drawable.lara))
    )
    Column(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp, 0.dp, 10.dp),
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            text = "Treinadores"
        )
        TextField(
            trailingIcon = { Icon(Icons.Filled.Search, null, tint = Color.Black) },
            colors = TextFieldDefaults.colors(
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp),
            shape = RoundedCornerShape(15.dp),
            placeholder = { Text(text = "Buscar um treinador")},
            value = search,
            onValueChange = { search = it }
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 10.dp, 0.dp, 5.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = "Sugestões"
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(60.dp, 0.dp, 60.dp, 0.dp)
        ) {
            items(10) {
                SuggestCard(navController)
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 10.dp, 0.dp, 5.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = "Favoritos"
        )
        Spacer(modifier = Modifier.size(0.dp, 20.dp))
        LazyColumn (
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 20.dp)
        ) {
            trainers.forEach { trainer ->
                item {
                    CardInstructor(trainer, navController)
                }
            }
        }
    }

}

@Composable
fun CardInstructor(trainer: Trainer, navController: NavController) {
    Card (
        modifier = Modifier
            .size(410.dp, 95.dp)
            .fillMaxWidth()
            .padding(20.dp, 10.dp)
            .background(Color(244, 151, 65))
            .clickable(
                onClick = {
                    navController.navigate(Screens.InstructorProfile.screen)
                },
                onClickLabel = "Click"
            )
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(244, 151, 65))
        ) {
            Image(
                painter = trainer.image,
                contentDescription = "Image",
                modifier = Modifier
                    .background(Color(244, 151, 65))
                    .size(height = 150.dp, width = 100.dp)
                    .padding(5.dp)
            )
            Column {
                Text(
                    modifier = Modifier
                        .padding(50.dp, 10.dp, 0.dp, 0.dp)
                        .background(Color(244, 151, 65)),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = trainer.name
                )
                Text(
                    modifier = Modifier
                        .padding(50.dp, 0.dp, 0.dp, 0.dp)
                        .background(Color(244, 151, 65)),
                    color = Color(255, 199, 70),
                    text = trainer.function
                )
            }
        }
    }
}

@Composable
fun SuggestCard(navController: NavController) {
    Card(
        modifier = Modifier
            .size(290.dp, 100.dp)
            .padding(20.dp, 5.dp)
            .clickable(
                onClick = {
                    navController.navigate(Screens.InstructorProfile.screen)
                },
                onClickLabel = "Click"
            )
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.raquel),
            contentDescription = "Image",
        )
    }
}
