package dsm.hackathon.dsmhackathon2023_team18.ui.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.Home
import dsm.hackathon.dsmhackathon2023_team18.ui.main.record.RecordScreen

fun NavGraphBuilder.mainNavigation(
    navController: NavHostController,
) {
    navigation(
        route = MainDestination.route,
        startDestination = MainDestination.home,
    ) {
        composable(MainDestination.home) {
            Home(
                onNavigateToRecord = navController::navigateToRecord,
            )
        }
        composable(MainDestination.record) {
            RecordScreen(
                onNavigateUp = navController::navigateUp,
            )
        }
    }
}

object MainDestination {
    const val route = "main"

    const val home = this.route + "/home"
    const val record = this.route + "/record"
}

fun NavHostController.navigateToRecord() {
    this.navigate(MainDestination.record) {
        launchSingleTop = true
        restoreState = true
    }
}
