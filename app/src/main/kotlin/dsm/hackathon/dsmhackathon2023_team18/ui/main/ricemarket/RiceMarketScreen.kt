package dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryColor
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.domain.DdeokMood
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray2
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray6
import dsm.hackathon.dsmhackathon2023_team18.ui.util.PrimaryButton
import dsm.hackathon.dsmhackathon2023_team18.ui.util.PrimaryIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiceMarketScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    onNavigateToSunMarket: () -> Unit,
    onNavigateToMoonMarket: () -> Unit,
) {
    val topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.Transparent,
    )
    var totalPoint by remember { mutableIntStateOf(1214508) }
    val onAddToTotalPoint = { other: Int -> totalPoint += other }
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "쌀 장터",
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
        Banner(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            MoodCard(
                modifier = Modifier.weight(0.3f),
                mood = DdeokMood.VERY_GOOD,
            )
            RicePointCard(
                modifier = Modifier.weight(0.7f),
                point = totalPoint,
            )
        }

        TaskCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            point = 10000,
            subject = "뒷산 올라가서 맑은 공기 쐐기",
            onButtonClick = onAddToTotalPoint,
        )
        TaskCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            point = 5000,
            subject = "가장 좋아하는 영화 다시 보기",
            onButtonClick = onAddToTotalPoint,
        )
        TaskCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            point = 3000,
            subject = "자신만의 소확행 떠올리기",
            onButtonClick = onAddToTotalPoint,
        )

        MarketCards(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onSunMarketClicked = onNavigateToSunMarket,
            onMoonMarketClicked = onNavigateToMoonMarket,
        )
    }
}

@Composable
private fun Banner(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .background(
                color = LocalPrimaryColor.current,
                shape = RoundedCornerShape(20.dp),
            )
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom,
    ) {
        Text(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp,
                ),
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = Color.White)) {
                    withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("미션")
                    }
                    append("을 완료하고\n")
                    withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("쌀")
                    }
                    append("을 받으세요!")
                }
            },
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.titleLarge,
        )
        Icon(
            modifier = Modifier
                .padding(top = 24.dp)
                .weight(0.4f),
            painter = painterResource(id = R.drawable.ic_ddeok_big),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

@Composable
private fun MoodCard(
    modifier: Modifier = Modifier,
    mood: DdeokMood,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Gray2,
                shape = RoundedCornerShape(20.dp),
            )
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = mood.text,
            style = MaterialTheme.typography.bodySmall,
            color = Gray1,
            textAlign = TextAlign.Center,
        )
        Icon(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = mood.selectedResId),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}


@Composable
private fun RicePointCard(
    modifier: Modifier = Modifier,
    mood: DdeokMood = DdeokMood.VERY_BAD,
    point: Int,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Gray2,
                shape = RoundedCornerShape(20.dp),
            )
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = mood.text,
            style = MaterialTheme.typography.bodySmall,
            color = Gray1,
            textAlign = TextAlign.Start,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "%,d".format(point) + " 톨",
            style = MaterialTheme.typography.headlineMedium,
            color = Gray1,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.SemiBold,
        )
    }
}

@Composable
private fun TaskCard(
    modifier: Modifier = Modifier,
    point: Int,
    subject: String,
    onButtonClick: (point: Int) -> Unit,
) {
    var buttonEnabled by remember { mutableStateOf(true) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Gray2,
                shape = RoundedCornerShape(20.dp),
            )
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(
                    color = LocalPrimaryColor.current,
                    shape = AbsoluteRoundedCornerShape(100),
                ),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = null,
                tint = Color.White,
            )
        }
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "%,d".format(point) + " 톨",
                color = Gray1,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = subject,
                color = Gray6,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        if (buttonEnabled) {
            PrimaryButton(
                text = "완료하기",
                onClick = {
                    onButtonClick(point)
                    buttonEnabled = false
                },
            )
        } else {
            PrimaryIconButton {}
        }
    }
}

@Composable
private fun MarketCards(
    modifier: Modifier = Modifier,
    onSunMarketClicked: () -> Unit,
    onMoonMarketClicked: () -> Unit,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .clickable(onClick = onSunMarketClicked),
            contentAlignment = Alignment.TopStart,
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_rice_market_sun_market),
                contentDescription = "sun market",
            )
            Text(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 12.dp,
                ),
                text = "햇님상점",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = Gray1,
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .clickable(onClick = onMoonMarketClicked),
            contentAlignment = Alignment.TopStart,
        ) {
            Image(
                painter = painterResource(id = R.drawable.bg_rice_market_moon_market),
                contentDescription = "moon market",
            )
            Text(
                modifier = Modifier.padding(
                    start = 16.dp,
                    top = 12.dp,
                ),
                text = "달님상점",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = Gray1,
            )
        }
    }
}
