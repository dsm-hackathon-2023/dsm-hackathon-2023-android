package dsm.hackathon.dsmhackathon2023_team18.ui.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authNavigation() {
    navigation(
        route = AuthDestination.route,
        startDestination = AuthDestination.login,
    ) {
        composable(AuthDestination.login) {

        }
    }
}

object AuthDestination {
    const val route = "auth"

    const val login = this.route + "/login"
}