package dsm.hackathon.dsmhackathon2023_team18.ui.main.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryDdeok
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.domain.DdeokMood
import dsm.hackathon.dsmhackathon2023_team18.ui.main.calendar.CalendarScreen
import dsm.hackathon.dsmhackathon2023_team18.ui.util.MoodModal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class DdeokState {
    DEFAULT, FULL_PRESSED, LOW_PRESSED, MIDDLE_PRESSED, HIGH_PRESSED,
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
    onNavigateToRecord: (mood: DdeokMood) -> Unit,
    onNavigateToRiceMarketNav: () -> Unit,
    onNavigateToTimelineNav: () -> Unit,
    onNavigateToReport: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val (shouldShowMoodModal, setMoodModalState) = remember { mutableStateOf(false) }
    var recordButtonState by remember { mutableStateOf(DdeokState.DEFAULT) }
    val topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.Transparent,
    )
    if (shouldShowMoodModal) {
        MoodModal(
            onClick = { mood -> onNavigateToRecord(mood) },
            onDismissRequest = { setMoodModalState(false) },
        )
    }
    var webViewUrl by rememberSaveable { mutableStateOf("https://onui.vercel.app/") }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_settings),
                            contentDescription = null,
                            tint = Color.White,
                        )
                    }
                },
                title = {},
                actions = {
                    Spacer(modifier = Modifier.width(16.dp))
                    IconButton(
                        modifier = Modifier.size(32.dp),
                        onClick = onNavigateToRiceMarketNav,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wallet),
                            tint = Color.White,
                            contentDescription = "wallet",
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(
                        modifier = Modifier.size(32.dp),
                        onClick = onNavigateToReport,
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
                        onClick = onNavigateToTimelineNav,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            tint = Color.White,
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
                modifier = Modifier.size(64.dp),
                onClick = {
                    if (recordButtonState == DdeokState.DEFAULT) {
                        setMoodModalState(true)
                        scope.launch {
                            recordButtonState = DdeokState.LOW_PRESSED
                            delay(10L)
                            recordButtonState = DdeokState.FULL_PRESSED
                            delay(100L)
                            recordButtonState = DdeokState.LOW_PRESSED
                            delay(100L)
                            recordButtonState = DdeokState.MIDDLE_PRESSED
                            delay(100L)
                            recordButtonState = DdeokState.HIGH_PRESSED
                            delay(50L)
                            recordButtonState = DdeokState.DEFAULT
                        }
                        CoroutineScope(Dispatchers.Default).launch {
                            delay(8000L)
                            webViewUrl = "https://onui.vercel.app/result"
                        }
                        Unit
                    }
                },
            ) {
                Icon(
                    painter = painterResource(
                        id = when (recordButtonState) {
                            DdeokState.DEFAULT -> LocalPrimaryDdeok.current.defaultResId
                            DdeokState.FULL_PRESSED -> LocalPrimaryDdeok.current.fullPressedResId
                            DdeokState.MIDDLE_PRESSED -> LocalPrimaryDdeok.current.middlePressedResId
                            DdeokState.LOW_PRESSED -> LocalPrimaryDdeok.current.lowPressedResId
                            DdeokState.HIGH_PRESSED -> LocalPrimaryDdeok.current.highPressedResId
                        },
                    ),
                    contentDescription = "create new record",
                    tint = Color.Unspecified,
                )
            }
        },
    ) {
        CalendarScreen(
            webViewUrl = webViewUrl,
        )
    }
}
