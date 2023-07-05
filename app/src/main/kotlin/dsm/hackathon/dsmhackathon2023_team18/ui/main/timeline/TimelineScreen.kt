@file:OptIn(ExperimentalMaterial3Api::class)

package dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1

@Composable
fun TimelineScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    val webViewState = rememberWebViewState(url = "https://onui.vercel.app/timeline")

    val topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.Transparent,
    )
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize(),
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "타임라인",
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
        WebView(
            modifier = modifier.weight(1f),
            state = webViewState,
        )
    }
}
