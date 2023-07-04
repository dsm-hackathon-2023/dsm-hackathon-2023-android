@file:OptIn(ExperimentalAnimationApi::class)

package dsm.hackathon.dsmhackathon2023_team18.ui.main.home

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.calendar.CalendarScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private fun expandFading(time: Int) =
    fadeIn(animationSpec = tween(time * 3)) with fadeOut(animationSpec = tween(time))

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
) {
    val scope = rememberCoroutineScope()
    var recordButtonClicked by remember { mutableStateOf(false) }
    val onRecordButtonClick = {
        if (!recordButtonClicked) {
            recordButtonClicked = true
            scope.launch {
                delay(1000L)
                recordButtonClicked = false
            }
            Unit
        }
    }
    val topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.Transparent,
    )

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_all),
                            contentDescription = null,
                            tint = Color.White,
                        )
                    }
                },
                title = { },
                actions = {
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(
                        modifier = Modifier.size(32.dp),
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_ddeok_very_good),
                            tint = Color.Unspecified,
                            contentDescription = "task",
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        modifier = Modifier.size(32.dp),
                        onClick = { /*TODO*/ },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_ddeok_very_bad),
                            tint = Color.Unspecified,
                            contentDescription = "timeline",
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                },
                colors = topAppBarColors,
            )
        },
        floatingActionButton = {
            IconButton(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .size(64.dp),
                onClick = onRecordButtonClick,
            ) {
                AnimatedContent(
                    targetState = recordButtonClicked,
                    label = "",
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
        },
    ) {
        CalendarScreen()
    }
}
