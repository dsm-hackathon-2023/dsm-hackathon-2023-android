package dsm.hackathon.dsmhackathon2023_team18.ui.main.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
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
    var selected by remember { mutableStateOf(HomeSections.CALENDAR) }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(
                    modifier = Modifier.height(48.dp),
                    containerColor = Color(0xFFF5594E),
                ) {
                    HomeSections.values().forEach { section ->
                        NavigationBarItem(
                            selected = section == selected,
                            modifier = Modifier.fillMaxHeight(),
                            onClick = {
                                selected = section
                                navController.navigate(section.route)
                            },
                            icon = {
                                Icon(
                                    imageVector = Icons.Filled.Call,
                                    contentDescription = "bottom app bar item",
                                )
                            },
                        )
                    }
                }
            },
        ) { padValues ->
            NavHost(
                modifier = Modifier
                    .padding(padValues)
                    .fillMaxSize(),
                navController = navController,
                startDestination = HomeSections.CALENDAR.route,
            ) {
                composable(HomeSections.CALENDAR.route) {}
                composable(HomeSections.COMMUNITY.route) {}
                composable(HomeSections.REPORT.route) {}
                composable(HomeSections.ALL.route) {}
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
