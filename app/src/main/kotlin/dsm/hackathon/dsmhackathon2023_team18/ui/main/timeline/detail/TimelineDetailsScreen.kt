@file:OptIn(ExperimentalMaterial3Api::class)

package dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryDdeok
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TimelineDetailsScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    val topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.Transparent,
    )
    var commentVisible by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        scope.launch {
            delay(1500L)
            commentVisible = true
        }
    }
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "2023년 7월 6일",
                    color = Gray1,
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = onNavigateUp,
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = Gray1,
                    )
                }
            },
            colors = topAppBarColors,
        )
        WebView(state = rememberWebViewState(url = "https://onui.vercel.app/Details"))
        AnimatedVisibility(
            visible = commentVisible,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp,
                        vertical = 24.dp,
                    ),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                DdeokMessage(message = "오늘 해커톤을 했는데요, 어쩌구. 화이팅 짱짱! 오누이 체고~")
                DdeokMessage(message = "ㅇㅇ ㅇㅈ")
                DdeokMessage(message = "나는 집에 가서 DMS 개발이나 하고 싶어. 특히 안드로이드가 야무지단말이야 ㅎㅎ")
            }
        }
    }
}

@Composable
private fun DdeokMessage(
    modifier: Modifier = Modifier,
    message: String,
) {
    val scope = rememberCoroutineScope()
    var ddeokClicked by remember { mutableStateOf(false) }
    val onDdeokClick = {
        if (!ddeokClicked) {
            ddeokClicked = true
            scope.launch {
                delay(1000L)
                ddeokClicked = false
            }
            Unit
        }
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.Start,
        ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier.size(48.dp),
            onClick = onDdeokClick,
        ) {
            Icon(
                painter = painterResource(
                    if (ddeokClicked) {
                        LocalPrimaryDdeok.current.pressedResId
                    } else {
                        LocalPrimaryDdeok.current.defaultResId
                    },
                ),
                contentDescription = "create new record",
                tint = Color.Unspecified,
            )
        }
        Text(
            modifier = Modifier
                .weight(1f)
                .background(
                    color = Gray2,
                    shape = RoundedCornerShape(20.dp),
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp,
                ),
            text = message,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.weight(0.05f))
    }
}
