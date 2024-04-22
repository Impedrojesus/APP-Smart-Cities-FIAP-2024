package br.com.fiap.trainertrack.screens

sealed class Screens(val screen: String) {

    data object Login: Screens("Login")
    data object Home: Screens("Home")
    data object Search: Screens("Search")
    data object Event: Screens("Event")
    data object Profile: Screens("Profile")
    data object InstructorProfile: Screens("InstructorProfile")

}