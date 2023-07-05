package dsm.hackathon.dsmhackathon2023_team18.ui.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dsm.hackathon.dsmhackathon2023_team18.ui.auth.login.SignInScreen
import dsm.hackathon.dsmhackathon2023_team18.ui.main.MainDestination

fun NavGraphBuilder.authNavigation(
    navController: NavHostController,
) {
    navigation(
        route = AuthDestination.route,
        startDestination = AuthDestination.login,
    ) {
        composable(AuthDestination.login) {
            SignInScreen(
                onNavigateToMainNav = {
                    navController.navigate(MainDestination.route) {
                        popUpTo(navController.currentDestination?.id!!) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

object AuthDestination {
    const val route = "auth"

    const val login = this.route + "/login"
}