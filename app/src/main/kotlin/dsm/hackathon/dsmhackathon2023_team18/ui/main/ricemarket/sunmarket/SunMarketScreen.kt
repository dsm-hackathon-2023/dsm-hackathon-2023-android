package dsm.hackathon.dsmhackathon2023_team18.ui.main.ricemarket.sunmarket

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SunMarketScreen(
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
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "햇님상점",
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
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(20.dp)),
            painter = painterResource(id = R.drawable.img_sun_market_banner),
            contentDescription = null,
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.img_sun_market_item_1),
            contentDescription = null,
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.img_sun_market_item_2),
            contentDescription = null,
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.img_sun_market_item_3),
            contentDescription = null,
        )
    }
}
