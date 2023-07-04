package dsm.hackathon.dsmhackathon2023_team18.ui.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.mainNavigation() {
    navigation(
        route = MainDestination.route,
        startDestination = MainDestination.route,
    ) {
        composable(MainDestination.home) {

        }
    }
}

object MainDestination {
    const val route = "main"

    const val home = "home"
}