@file:OptIn(ExperimentalMaterial3Api::class)

package dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline

import android.annotation.SuppressLint
import android.webkit.JavascriptInterface
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.web.rememberWebViewState
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("SetJavaScriptEnabled")
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
        Image(
            painter = painterResource(id = R.drawable.img_timeline_date),
            contentDescription = null,
        )
        val pagerState = rememberPagerState { 3 }
        VerticalPager(
            modifier = Modifier.fillMaxSize(),
            state = pagerState,
            contentPadding = PaddingValues(top = 72.dp),
        ) { page ->
            Image(
                modifier = Modifier
                    .graphicsLayer {
                        val pagerOffset =
                            ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                        lerp(
                            start = 0.875f, stop = 1f, fraction = 1f - pagerOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pagerOffset.coerceIn(0f, 1f),
                        )
                    }
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                painter = painterResource(
                    id = when (page) {
                        0 -> R.drawable.dummy_img_timeline_1
                        1 -> R.drawable.dummy_img_timeline_2
                        2 -> R.drawable.dummy_img_timeline_3
                        else -> throw IllegalStateException()
                    },
                ),
                contentDescription = "list item",
            )
        }
    }

    /* WebView(
         modifier = modifier.weight(1f),
         state = webViewState,
         onCreated = { webView ->
             with(webView) {
                 settings.run {
                     javaScriptEnabled = true
                     domStorageEnabled = true
                     javaScriptCanOpenWindowsAutomatically = false
                     addJavascriptInterface(JsBridge(), "Native")
                 }
             }
         }
     )*//*AndroidView(
            factory = { context ->
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    setBackgroundColor(android.graphics.Color.TRANSPARENT)
                    loadUrl("file:///android_asset/webviewbridge.html")
                    addJavascriptInterface(
                        JsBridge(),
                        "Native",
                    )
                }
            },
        )*/
}

class JsBridge {
    @JavascriptInterface
    fun bridge() {
        println("MSGMSGMSGMSG")
    }
}
