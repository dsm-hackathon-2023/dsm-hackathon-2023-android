package dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.riceMarketNavigation(
    navController: NavHostController,
) {
    navigation(
        route = RiceMarketNavigation.route,
        startDestination = RiceMarketNavigation.main,
    ) {
        composable(RiceMarketNavigation.main) {
            RiceMarketScreen(
                onNavigateUp = {
                    navController.navigateUp()
                },
            )
        }
        composable(RiceMarketNavigation.sunMarket) {

        }
        composable(RiceMarketNavigation.moonMarket) {

        }
    }
}

object RiceMarketNavigation {
    const val route = "riceMarket"

    const val main = this.route + "/main"
    const val sunMarket = this.route + "/sunMarket"
    const val moonMarket = this.route + "/moonMarket"
}

fun NavHostController.navigateToRiceMarketNav() {
    this.navigate(RiceMarketNavigation.route) {
        launchSingleTop = true
        restoreState = true
    }
}
