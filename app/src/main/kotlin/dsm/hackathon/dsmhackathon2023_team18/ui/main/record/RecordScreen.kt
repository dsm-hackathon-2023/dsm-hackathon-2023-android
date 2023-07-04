package dsm.hackathon.dsmhackathon2023_team18.ui.main.record

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryDdeok
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray2
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = "감정 기록하기",
                )
            },
            navigationIcon = {
                IconButton(
                    onClick = onNavigateUp,
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                    )
                }
            },
        )
        DdeokMessage(message = "안녕하세요. 오늘 하루도 잘 보내셨나요? \n오늘 당신의 하루는 어땠는지 말씀해주세요!")
    }
}

@Composable
private fun DdeokMessage(
    modifier: Modifier = Modifier,
    message: String,
) {
    val scope = rememberCoroutineScope()
    var ddeokClicked by remember { mutableStateOf(false) }
    val onDdeokClick = {
        if (!ddeokClicked) {
            ddeokClicked = true
            scope.launch {
                delay(1000L)
                ddeokClicked = false
            }
            Unit
        }
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.Start,
        ),
        verticalAlignment = Alignment.Top,
    ) {
        IconButton(
            modifier = Modifier.size(64.dp),
            onClick = onDdeokClick,
        ) {
            Icon(
                painter = painterResource(
                    if (ddeokClicked) {
                        LocalPrimaryDdeok.current.pressedResId
                    } else {
                        LocalPrimaryDdeok.current.defaultResId
                    },
                ),
                contentDescription = "create new record",
                tint = Color.Unspecified,
            )
        }

        Text(
            modifier = Modifier
                .background(Gray2)
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp,
                ),
            text = message,
        )
    }
}
