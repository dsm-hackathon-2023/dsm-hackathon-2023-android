package dsm.hackathon.dsmhackathon2023_team18.ui.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.Home
import dsm.hackathon.dsmhackathon2023_team18.ui.main.record.RecordScreen
import dsm.hackathon.dsmhackathon2023_team18.ui.main.report.ReportScreen
import dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket.navigateToRiceMarketNav
import dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket.riceMarketNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline.navigateToTimelineNav
import dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline.timelineNavigation

fun NavGraphBuilder.mainNavigation(
    navController: NavHostController,
) {
    navigation(
        route = MainDestination.route,
        startDestination = MainDestination.home,
    ) {
        composable(MainDestination.settings) {

        }
        composable(MainDestination.home) {
            Home(
                onNavigateToRecord = navController::navigateToRecord,
                onNavigateToRiceMarketNav = navController::navigateToRiceMarketNav,
                onNavigateToTimelineNav = navController::navigateToTimelineNav,
                onNavigateToReport = navController::navigateToReport,
            )
        }
        composable(MainDestination.record) {
            RecordScreen(
                onNavigateUp = navController::navigateUp,
            )
        }
        composable(MainDestination.report) {
            ReportScreen(
                onNavigateUp = navController::navigateUp,
            )
        }
        riceMarketNavigation(navController)
        timelineNavigation(navController)
    }
}

object MainDestination {
    const val route = "main"

    const val home = this.route + "/home"
    const val settings = this.route + "/settings"
    const val report = this.route + "/report"
    const val record = this.route + "/record"
}

fun NavHostController.navigateToRecord() {
    this.navigate(MainDestination.record) {
        launchSingleTop = true
        restoreState = true
    }
}

fun NavHostController.navigateToReport() {
    this.navigate(MainDestination.report) {
        launchSingleTop = true
        restoreState = true
    }
}
