package dsm.hackathon.dsmhackathon2023_team18.ui.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.HomeSections.ALL
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.HomeSections.CALENDAR
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.HomeSections.COMMUNITY
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.HomeSections.REPORT
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    var recordButtonClicked by remember { mutableStateOf(false) }
    val onRecordButtonClick by remember {
        mutableStateOf(
            {
                recordButtonClicked = true
                scope.launch {
                    delay(1000L)
                    recordButtonClicked = false
                }
                Unit
            },
        )
    }
    var selected by remember { mutableStateOf(CALENDAR) }
    val navColors = NavigationBarItemDefaults.colors(
        selectedIconColor = Color.White,
        selectedTextColor = Color.White,
        indicatorColor = Color(0xFFCD3E34),
        unselectedIconColor = Color(0xFFCD3E34),
        unselectedTextColor = Color(0xFFCD3E34),
    )

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    modifier = Modifier
                        .height(52.dp),
                    containerColor = Color(0xFFF5594E),
                ) {
                    Spacer(modifier = Modifier.width(8.dp))
                    NavigationBarItem(
                        colors = navColors,
                        selected = selected == CALENDAR,
                        modifier = Modifier.fillMaxHeight(),
                        onClick = {
                            selected = CALENDAR
                            navController.navigate(CALENDAR.route)
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "bottom app bar item",
                            )
                        },
                    )
                    NavigationBarItem(
                        colors = navColors,
                        selected = selected == COMMUNITY,
                        modifier = Modifier.fillMaxHeight(),
                        onClick = {
                            selected = COMMUNITY
                            navController.navigate(COMMUNITY.route)
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.FavoriteBorder,
                                contentDescription = "bottom app bar item",
                            )
                        },
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    NavigationBarItem(
                        colors = navColors,
                        selected = selected == REPORT,
                        modifier = Modifier.fillMaxHeight(),
                        onClick = {
                            selected = REPORT
                            navController.navigate(REPORT.route)
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Person,
                                contentDescription = "bottom app bar item",
                            )
                        },
                    )
                    NavigationBarItem(
                        colors = navColors,
                        selected = selected == ALL,
                        modifier = Modifier.fillMaxHeight(),
                        onClick = {
                            selected = ALL
                            navController.navigate(ALL.route)
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "bottom app bar item",
                            )
                        },
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                }
            },
        ) { padValues ->
            NavHost(
                modifier = Modifier
                    .background(Color(0xFFF5F0EF))
                    .padding(padValues)
                    .fillMaxSize(),
                navController = navController,
                startDestination = CALENDAR.route,
            ) {
                composable(CALENDAR.route) {}
                composable(COMMUNITY.route) {}
                composable(REPORT.route) {}
                composable(ALL.route) {}
            }
        }
        IconButton(
            modifier = Modifier
                .padding(bottom = 24.dp)
                .size(52.dp),
            onClick = onRecordButtonClick,
        ) {
            Icon(
                painter = painterResource(
                    if (recordButtonClicked) {
                        R.drawable.ic_rice_cake_button_pressed
                    } else {
                        R.drawable.ic_rice_cake_button_default
                    },
                ),
                contentDescription = "create new record",
                tint = Color.Unspecified,
            )
        }
    }
}

private enum class HomeSections(
    val route: String,
) {
    CALENDAR(
        route = "calendar",
    ),
    COMMUNITY(
        route = "community",
    ),
    REPORT(
        route = "report",
    ),
    ALL(
        route = "all"
    ),
}
