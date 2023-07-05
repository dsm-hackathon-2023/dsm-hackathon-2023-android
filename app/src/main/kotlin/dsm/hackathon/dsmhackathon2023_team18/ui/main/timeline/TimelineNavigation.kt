package dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

object TimelineNavigation {
    const val route = "timeline"

    const val main = this.route + "/main"
    const val details = this.route + "/details"
}

fun NavGraphBuilder.timelineNavigation() {
    navigation(
        route = TimelineNavigation.route,
        startDestination = TimelineNavigation.main,
    ) {
        composable(TimelineNavigation.main) {

        }
        composable(TimelineNavigation.details) {

        }
    }
}

fun NavHostController.navigateToTimelineNav() {
    this.navigate(TimelineNavigation.route) {
        launchSingleTop = true
        restoreState = true
    }
}
