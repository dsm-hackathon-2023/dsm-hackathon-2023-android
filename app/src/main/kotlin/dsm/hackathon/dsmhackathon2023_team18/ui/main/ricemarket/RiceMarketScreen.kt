package dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RiceMarketScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    val topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.Transparent,
    )
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
