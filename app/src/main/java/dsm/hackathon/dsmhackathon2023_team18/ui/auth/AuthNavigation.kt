package dsm.hackathon.dsmhackathon2023_team18.ui.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

fun NavGraphBuilder.authNavigation() {
    navigation()
}

object AuthDestination {
    const val route = "auth"

    const val login = this.route + "/login"
}