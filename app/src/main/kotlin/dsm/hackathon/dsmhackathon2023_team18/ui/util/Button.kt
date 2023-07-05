package dsm.hackathon.dsmhackathon2023_team18.ui.util

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryColor

@Composable
fun LargePrimaryButton(
    modifier: Modifier = Modifier,
    color: Color = LocalPrimaryColor.current,
    text: String,
    onClick: () -> Unit,
) {
    PrimaryButton(
        modifier = modifier.fillMaxWidth(),
        textModifier = Modifier.fillMaxWidth(),
        color = color,
        text = text,
        onClick = onClick,
    )
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    color: Color = LocalPrimaryColor.current,
    text: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(
                color = color,
                shape = RoundedCornerShape(20.dp),
            )
            .clip(RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
    ) {
        Text(
            modifier = textModifier,
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun PrimaryIconButton(
    modifier: Modifier = Modifier,
    color: Color = LocalPrimaryColor.current,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(
                color = color,
                shape = RoundedCornerShape(20.dp),
            )
            .clip(RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = null,
            tint = Color.White,
        )
    }
}

@Composable
fun SocialIconButton(
    modifier: Modifier = Modifier,
    painter: Painter,
    text: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .background(
                color = Color.White,
                shape = RoundedCornerShape(20.dp),
            )
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            tint = LocalPrimaryColor.current,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            color = LocalPrimaryColor.current,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
        )
    }
}
