package dsm.hackathon.dsmhackathon2023_team18.ui.main.record

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryColor
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
    val (selectedDdeokMood, onDdeokMoodSelected) = remember { mutableStateOf<DdeokMood?>(null) }
    val selectedMoods = remember { mutableStateListOf<Mood>() }
    val onMoodSelected = { mood: Mood, selected: Boolean ->
        if (selected) {
            selectedMoods.add(mood)
        } else {
            selectedMoods.remove(mood)
        }
        Unit
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
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
            message = "안녕하세요. 오늘 하루도 잘 보내셨나요?\n오늘 당신의 하루는 어땠는지 말씀해주세요!",
        )
        DdeokPicker(
            selectedMood = selectedDdeokMood,
            onMoodSelect = onDdeokMoodSelected,
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )

        DdeokMessage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            message = "그렇군요. 오늘 하루도 고생 많으셨습니다.\n오늘은 어떤 감정들을 느꼈는지 찰떡에게\n말씀해주세요!",
        )
        MoodChips(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            selectedMoods = selectedMoods,
            onMoodSelect = onMoodSelected,
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
        DdeokMessage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            message = "안녕하세요. 오늘 하루도 잘 보내셨나요? \n오늘 당신의 하루는 어땠는지 말씀해주세요!",
        )


        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
        DdeokMessage(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            message = "안녕하세요. 오늘 하루도 잘 보내셨나요? \n오늘 당신의 하루는 어땠는지 말씀해주세요!",
        )


        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
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
    onMoodSelect: (mood: DdeokMood) -> Unit,
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
                    onClick = { onMoodSelect(mood) },
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

private enum class Mood(
    val text: String,
) {
    EXCITING("신나요"), COMFORTABLE("편안해요"), PROUD("뿌듯해요"), EXPECTED("기대돼요"), HAPPY("행복해요"), EAGER("의욕적이에요"), FLUTTERING(
        "설레요"
    ),
    FRESH("상쾌해요"), DEPRESSED("우울해요"), LONELY("외로워요"), UNEASY("불안해요"), SAD("슬퍼요"), ANGRY("화나요"), BURDENED(
        "부담돼요"
    ),
    FRUSTRATED("짜증나요"), TIRED("피곤해요"),
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MoodChips(
    modifier: Modifier = Modifier,
    selectedMoods: List<Mood>,
    onMoodSelect: (mood: Mood, selected: Boolean) -> Unit,
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterHorizontally,
        )
    ) {
        Mood.values().forEach { mood ->
            val selected = selectedMoods.contains(mood)
            MoodChip(mood = mood) {
                onMoodSelect(mood, selected)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MoodChip(
    modifier: Modifier = Modifier,
    mood: Mood,
    onClick: () -> Unit,
) {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        modifier = modifier,
        selected = selected,
        onClick = { selected = !selected },
        label = {
            Text(
                text = mood.text,
                style = MaterialTheme.typography.labelMedium,
                color = if (selected) {
                    Color.White
                } else {
                    Gray1
                },
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedLabelColor = LocalPrimaryColor.current,
            selectedContainerColor = LocalPrimaryColor.current,
        ),
    )
}
