package dsm.hackathon.dsmhackathon2023_team18.ui.main.timeline

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryColor
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray6
import kotlin.math.absoluteValue

val listFadeBrush: Brush
    @Composable get() = Brush.verticalGradient(
        colors = listOf(
            Color.White,
            Color.White,
            Color.Transparent,
        ),
    )

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@SuppressLint("SetJavaScriptEnabled")
@Composable
fun TimelineScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    onNavigateToDetails: () -> Unit,
) {
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
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_timeline_date),
                contentDescription = null,
                tint = LocalPrimaryColor.current,
            )
            Text(
                text = "6 금",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
            )
        }
        val pagerState = rememberPagerState { 3 }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter,
        ) {
            VerticalPager(
                modifier = Modifier.fillMaxSize(),
                state = pagerState,
                contentPadding = PaddingValues(top = 84.dp),
            ) { page ->
                when (page) {
                    1, 2 -> {
                        Icon(
                            modifier = Modifier.fillMaxWidth(),
                            imageVector = Icons.Filled.KeyboardArrowUp,
                            contentDescription = null,
                            tint = Gray6,
                        )
                    }
                }
                Image(
                    modifier = Modifier
                        .graphicsLayer {
                            val pagerOffset =
                                ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue

                            lerp(
                                start = 0.875f,
                                stop = 1f,
                                fraction = 1f - pagerOffset.coerceIn(0f, 1f)
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
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .clickable(onClick = onNavigateToDetails),
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
                when (page) {
                    0, 1 -> {
                        Icon(
                            modifier = Modifier.fillMaxWidth(),
                            imageVector = Icons.Filled.KeyboardArrowDown,
                            contentDescription = null,
                            tint = Gray6,
                        )
                    }
                }
            }
            Spacer(
                Modifier
                    .fillMaxWidth()
                    .height(36.dp)
                    .background(listFadeBrush),
            )
        }
    }
}
