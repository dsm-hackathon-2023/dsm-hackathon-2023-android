package dsm.hackathon.dsmhackathon2023_team18.ui.main.home.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Primary

@Composable
fun CalendarScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .background(Primary)
            .fillMaxSize(),
    ) {
        Banner(modifier = Modifier.height(160.dp))
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 32.dp,
                    ),
                ),
        ) {

        }
    }
}

@Composable
private fun Banner(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {

    }
}
