package dsm.hackathon.dsmhackathon2023_team18.ui.main.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryDdeok
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.main.home.calendar.CalendarScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
    onNavigateToRecord: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    var recordButtonClicked by remember { mutableStateOf(false) }
    val onRecordButtonClick = {
        onNavigateToRecord()
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
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
            ) {
                TopAppBar(
                    navigationIcon = {
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_settings),
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
                                painter = painterResource(id = R.drawable.ic_report),
                                tint = Color.White,
                                contentDescription = "report",
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(
                            modifier = Modifier.size(32.dp),
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_timeline),
                                tint = Color.White,
                                contentDescription = "timeline",
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                    },
                    colors = topAppBarColors,
                )
            }
        },
        floatingActionButton = {
            IconButton(
                modifier = Modifier.size(64.dp),
                onClick = onRecordButtonClick,
            ) {
                Icon(
                    painter = painterResource(
                        if (recordButtonClicked) {
                            LocalPrimaryDdeok.current.pressedResId
                        } else {
                            LocalPrimaryDdeok.current.defaultResId
                        },
                    ),
                    contentDescription = "create new record",
                    tint = Color.Unspecified,
                )
            }
        },
    ) {
        CalendarScreen()
    }
}
