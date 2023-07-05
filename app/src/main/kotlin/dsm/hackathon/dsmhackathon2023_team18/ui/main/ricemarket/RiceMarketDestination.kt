package dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket.moonmarket.MoonMarketScreen
import dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket.sunmarket.SunMarketScreen

fun NavGraphBuilder.riceMarketNavigation(
    navController: NavHostController,
) {
    navigation(
        route = RiceMarketDestination.route,
        startDestination = RiceMarketDestination.main,
    ) {
        composable(RiceMarketDestination.main) {
            RiceMarketScreen(
                onNavigateUp = navController::navigateUp,
                onNavigateToSunMarket = navController::navigateToSunMarket,
                onNavigateToMoonMarket = navController::navigateToMoonMarket,
            )
        }
        composable(RiceMarketDestination.sunMarket) {
            SunMarketScreen(onNavigateUp = navController::navigateUp)
        }
        composable(RiceMarketDestination.moonMarket) {
            MoonMarketScreen(onNavigateUp = navController::navigateUp)
        }
    }
}

object RiceMarketDestination {
    const val route = "riceMarket"

    const val main = this.route + "/main"
    const val sunMarket = this.route + "/sunMarket"
    const val moonMarket = this.route + "/moonMarket"
}

fun NavHostController.navigateToRiceMarketNav() {
    this.navigate(RiceMarketDestination.route) {
        launchSingleTop = true
        restoreState = true
    }
}

private fun NavHostController.navigateToSunMarket() {
    this.navigate(RiceMarketDestination.sunMarket) {
        launchSingleTop = true
        restoreState = true
    }
}

private fun NavHostController.navigateToMoonMarket() {
    this.navigate(RiceMarketDestination.moonMarket) {
        launchSingleTop = true
        restoreState = true
    }
}
