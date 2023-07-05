package dsm.hackathon.dsmhackathon2023_team18.ui.main.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryColor
import dsm.hackathon.dsmhackathon2023_team18.R

@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(LocalPrimaryColor.current)
            .fillMaxSize(),
    ) {
        Banner(
            modifier = Modifier.height(240.dp),
        )
        Column(
            modifier = modifier
                .weight(1f)
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 32.dp,
                    ),
                ),
        ) {
            val webViewState = rememberWebViewState(url = "https://www.naver.com/")
            WebView(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp,
                        ),
                    ),
                state = webViewState,
            )
        }
    }
}

@Composable
private fun Banner(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .padding(
                top = 88.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 24.dp,
            ),
        verticalAlignment = Alignment.Bottom,
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp),
        ) {
            Text(
                text = "오누이",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
            Text(
                buildAnnotatedString {
                    withStyle(SpanStyle(color = Color.White)) {
                        append("오늘 ")
                        withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("누군가")
                        }
                        append("의 이야기,\n오늘의 ")
                        withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                            append("감정")
                        }
                        append("은 어떠신가요?")
                    }
                },
            )
        }
        Icon(
            modifier = Modifier.weight(1f),
            painter = painterResource(id = R.drawable.ic_ddeok_twice),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

private fun Modifier.fixedSystemBarsPadding(): Modifier = composed {
    val systemBarsPadding = WindowInsets.systemBars.asPaddingValues()
    this.padding(systemBarsPadding)
}
