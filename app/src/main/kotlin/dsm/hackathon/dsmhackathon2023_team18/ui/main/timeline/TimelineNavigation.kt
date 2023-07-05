package dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline.detail.TimelineDetailsScreen

object TimelineNavigation {
    const val route = "timeline"

    const val main = this.route + "/main"
    const val details = this.route + "/details"
}

fun NavGraphBuilder.timelineNavigation(
    navController: NavHostController,
) {
    navigation(
        route = TimelineNavigation.route,
        startDestination = TimelineNavigation.main,
    ) {
        composable(TimelineNavigation.main) {
            TimelineScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateUp = navController::navigateUp,
                onNavigateToDetails = navController::navigateToTimelineDetails,
            )
        }
        composable(TimelineNavigation.details) {
            TimelineDetailsScreen(
                modifier = Modifier.fillMaxSize(),
                onNavigateUp = navController::navigateUp,
            )
        }
    }
}

fun NavHostController.navigateToTimelineNav() {
    this.navigate(TimelineNavigation.route) {
        launchSingleTop = true
        restoreState = true
    }
}

fun NavHostController.navigateToTimelineDetails() {
    this.navigate(TimelineNavigation.details) {
        launchSingleTop = true
    }
}
