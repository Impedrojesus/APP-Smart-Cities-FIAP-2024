package br.com.fiap.trainertrack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.trainertrack.R

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember {
        mutableStateOf("")
    }

    var senha by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // -----header------
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(255, 123, 0))
                    .padding(top = 10.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Row() {
                    Text(
                        text = "TRAINER",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 30.sp
                        )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(
                        text = "TRACK",
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                        fontSize = 30.sp,
                        )
                }

                Image(
                    painter = painterResource(id = R.drawable.spiner),
                    contentDescription = "Logo"
                )
            }
            // -----formulário-----
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Card(
                    modifier = Modifier
                        .height(320.dp)
                        .fillMaxWidth()
//                    .padding(top = (-10).dp)
                        .offset(y = (-5).dp),

                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    //border = BorderStroke(width = 2.dp, Color.LightGray),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(
                            vertical = 16.dp,
                            horizontal = 32.dp
                        )
                    ) {
                        Text(
                            text = "Seja Bem-vindo!",
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(255, 123, 0),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Seu e-mail",
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        OutlinedTextField(
                            value = email,
                            onValueChange = {
                                email = it
                            },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = {
                                Text(
                                    text = "Digite seu e-mail",

                                    )

                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Gray,
                                focusedBorderColor = Color(255, 123, 0)
                            ),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "Sua senha",
                            modifier = Modifier.padding(bottom = 8.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        OutlinedTextField(
                            value = senha,
                            onValueChange = {
                                senha = it
                            },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = {
                                Text(text = "Digite sua senha")
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = Color.Gray,
                                focusedBorderColor = Color(255, 123, 0)
                            ),
                            shape = RoundedCornerShape(16.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(

                            onClick = {navController.navigate(Screens.Home.screen)},
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(
                                    255,
                                    123,
                                    0
                                )
                            )
                        ) {
                            Text(
                                text = "Entrar",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 14.sp
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Ou faça login com",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        modifier = Modifier.border(1.dp, Color.DarkGray, shape = RoundedCornerShape(20.dp)),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(
                            241,
                            240,
                            239,
                            255
                        )
                    ),
                    ) {
                        Row()
                        {
                            Image(
                                painter = painterResource(id = R.drawable.facebook),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(35.dp),

                                )
                        }
                    }
                    Button(
                        modifier = Modifier.border(1.dp, Color.DarkGray, shape = RoundedCornerShape(20.dp)),
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(containerColor = Color(
                            241,
                            240,
                            239,
                            255
                        )
                        ),
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = R.drawable.google),
                                contentDescription = "",
                                modifier = Modifier
                                    .height(30.dp)
                                    .width(35.dp)
                            )
                        }
                    }
                }
            }

        }

    }
}
