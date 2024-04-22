package br.com.fiap.trainertrack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.fiap.trainertrack.screens.EventScreen
import br.com.fiap.trainertrack.screens.LoginScreen
import br.com.fiap.trainertrack.screens.ProfileScreen
import br.com.fiap.trainertrack.screens.Screens
import br.com.fiap.trainertrack.screens.SearchScreen
import br.com.fiap.trainertrack.screens.TrainerProfileScreen
import br.com.fiap.trainertrack.screens.TrainerScreen
import br.com.fiap.trainertrack.ui.theme.TrainerTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TrainerTrackTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MyBottomAppBar()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyBottomAppBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    var showBottomBar by rememberSaveable { mutableStateOf(false) }
    val navBackStackEntry by navigationController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        Screens.Login.screen -> false
        else -> true
    }

    Scaffold(
        containerColor = Color(255, 123, 0),
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    containerColor = Color.White
                ) {
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Home
                            navigationController.navigate(Screens.Home.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Home) Color.Black else Color.DarkGray
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.DateRange
                            navigationController.navigate(Screens.Event.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.DateRange) Color.Black else Color.DarkGray
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Search
                            navigationController.navigate(Screens.Search.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Search) Color.Black else Color.DarkGray
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Person
                            navigationController.navigate(Screens.Profile.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Person) Color.Black else Color.DarkGray
                        )
                    }
                }
            }
        }
    ) {
        paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Login.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Login.screen) {
                LoginScreen(navController = navigationController)
            }
            composable(Screens.Home.screen) {
                TrainerScreen(navController = navigationController)
            }
            composable(Screens.Profile.screen) {
                ProfileScreen(navController = navigationController)
            }
            composable(Screens.Event.screen) {
                EventScreen(navController = navigationController)
            }
            composable(Screens.Search.screen) {
                SearchScreen(navController = navigationController)
            }
            composable(Screens.InstructorProfile.screen) {
                TrainerProfileScreen(navController = navigationController)
            }
        }
    }
}

@Composable
@Preview
fun MyBottomBarPreview() {
    TrainerTrackTheme {
        MyBottomAppBar()
    }
}
