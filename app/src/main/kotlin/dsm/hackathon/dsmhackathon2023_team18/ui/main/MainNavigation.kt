package dsm.hackathon.dsmhackathon2023_team18.ui.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.Home

fun NavGraphBuilder.mainNavigation() {
    navigation(
        route = MainDestination.route,
        startDestination = MainDestination.home,
    ) {
        composable(MainDestination.home) {
            Home()
        }
    }
}

object MainDestination {
    const val route = "main"

    const val home = "home"
}