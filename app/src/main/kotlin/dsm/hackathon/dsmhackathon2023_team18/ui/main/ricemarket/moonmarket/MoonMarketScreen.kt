package dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket.moonmarket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoonMarketScreen(
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
                    text = "달님상점",
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.img_moon_market_banner),
            contentDescription = null,
        )
        listOf(
            R.drawable.img_moon_market_item_1,
            R.drawable.img_moon_market_item_2,
            R.drawable.img_moon_market_item_3,
            R.drawable.img_moon_market_item_4,
        ).forEach { resId ->
            MoonsangItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                resId = resId,
            )
        }
    }
}

@Composable
private fun MoonsangItem(
    modifier: Modifier = Modifier,
    resId: Int,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.CenterStart,
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = resId),
            contentDescription = null,
        )
        Image(
            modifier = Modifier
                .padding(start = 16.dp)
                .size(56.dp),
            painter = painterResource(id = R.drawable.img_moonsang),
            contentDescription = null,
        )
    }
}
