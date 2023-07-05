package dsm.hackathon.dsmhackathon2023_team18.ui.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import dsm.hackathon.dsmhackathon2023_team18.R

@Composable
fun DdeokDivider(
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.img_divider),
        contentDescription = null,
    )
}
