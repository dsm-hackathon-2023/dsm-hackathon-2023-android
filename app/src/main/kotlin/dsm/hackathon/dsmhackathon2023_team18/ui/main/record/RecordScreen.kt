package dsm.hackathon.dsmhackathon2023_team18.ui.main.record

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryDdeok
import dsm.hackathon.dsmhackathon2023_team18.domain.DdeokMood
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray1
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray2
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.Gray5
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecordScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    val topAppBarColors = TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.Transparent,
    )
    val (selectedMood, onMoodSelected) = remember { mutableStateOf<DdeokMood?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Spacer(modifier = Modifier.height(24.dp))
        TopAppBar(
            title = {
                Text(
                    text = "감정 기록하기",
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
        DdeokMessage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            message = "안녕하세요. 오늘 하루도 잘 보내셨나요? \n오늘 당신의 하루는 어땠는지 말씀해주세요!",
        )
        DdeokPicker(
            selectedMood = selectedMood,
            onMoodSelected = onMoodSelected,
        )
        DdeokMessage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            message = "안녕하세요. 오늘 하루도 잘 보내셨나요? \n오늘 당신의 하루는 어땠는지 말씀해주세요!",
        )
        DdeokMessage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            message = "안녕하세요. 오늘 하루도 잘 보내셨나요? \n오늘 당신의 하루는 어땠는지 말씀해주세요!",
        )
        DdeokMessage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            message = "안녕하세요. 오늘 하루도 잘 보내셨나요? \n오늘 당신의 하루는 어땠는지 말씀해주세요!",
        )
        DdeokMessage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            message = "안녕하세요. 오늘 하루도 잘 보내셨나요? \n오늘 당신의 하루는 어땠는지 말씀해주세요!",
        )
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
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier.size(48.dp),
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
                .background(
                    color = Gray2,
                    shape = RoundedCornerShape(20.dp),
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp,
                ),
            text = message,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
private fun DdeokPicker(
    modifier: Modifier = Modifier,
    selectedMood: DdeokMood?,
    onMoodSelected: (mood: DdeokMood) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = Gray5,
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
            text = "오늘은 어떤 하루였나요?",
            style = MaterialTheme.typography.bodySmall,
            color = Gray1,
            textAlign = TextAlign.Center,
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            DdeokMood.values().forEach { mood ->
                IconButton(
                    onClick = { onMoodSelected(mood) },
                ) {
                    Icon(
                        modifier = Modifier.size(48.dp),
                        painter = painterResource(
                            id = if (mood == selectedMood) {
                                mood.selectedResId
                            } else {
                                mood.unselectedResId
                            },
                        ),
                        contentDescription = "mood",
                        tint = Color.Unspecified,
                    )
                }
            }
        }
    }
}
