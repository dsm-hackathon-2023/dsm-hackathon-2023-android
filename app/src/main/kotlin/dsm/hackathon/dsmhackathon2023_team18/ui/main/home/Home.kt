package dsm.hackathon.dsmhackathon2023_team18.ui.main.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFFF5594E),
                actions = {
                    /*IconButton(onClick = { *//* Check onClick *//* }) {
                        Icon(Icons.Filled.Check, contentDescription = "", tint = Color.White)
                    }
                    IconButton(onClick = { *//* Edit onClick *//* }) {
                        Icon(
                            Icons.Filled.Edit, contentDescription = "", tint = Color.White)
                    }
                    IconButton(onClick = { *//* Delete onClick *//* }) {
                        Icon(Icons.Filled.Delete, contentDescription = "", tint = Color.White,)
                    }*/
                },
                floatingActionButton = {
                    IconButton(
                        modifier = Modifier.size(52.dp),
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
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
    ) { padValues ->
        NavHost(
            modifier = Modifier
                .padding(padValues)
                .fillMaxSize(),
            navController = navController,
            startDestination = HomeSections.CALENDAR.route,
        ) {
            composable(HomeSections.CALENDAR.route) {}
        }
    }
}

private enum class HomeSections(
    val route: String,
) {
    CALENDAR(
        route = "calendar",
    )
}
