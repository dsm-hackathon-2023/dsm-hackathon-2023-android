package dsm.hackathon.dsmhackathon2023_team18.domain

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.PrimaryGreen
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.PrimaryPink
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.PrimaryYellow

enum class DdeokMood(
    val text: String,
    @DrawableRes val selectedResId: Int,
    @DrawableRes val unselectedResId: Int,
) {
    VERY_GOOD(
        text = "아주 좋아요!",
        selectedResId = R.drawable.ic_ddeok_very_good,
        unselectedResId = R.drawable.ic_ddeok_very_good_disabled,
    ),
    GOOD(
        text = "좋아요!",
        selectedResId = R.drawable.ic_ddeok_good,
        unselectedResId = R.drawable.ic_ddeok_good_disabled,
    ),
    NORMAL(
        text = "평범해요",
        selectedResId = R.drawable.ic_ddeok_normal,
        unselectedResId = R.drawable.ic_ddeok_normal_disabled,
    ),
    BAD(
        text = "그럭저럭해요",
        selectedResId = R.drawable.ic_ddeok_bad,
        unselectedResId = R.drawable.ic_ddeok_bad_disabled,
    ),
    VERY_BAD(
        text = "아주 나빠요..",
        selectedResId = R.drawable.ic_ddeok_very_bad,
        unselectedResId = R.drawable.ic_ddeok_very_bad_disabled,
    ),
}

enum class PrimaryDdeok(
    val color: Color,
    @DrawableRes val defaultResId: Int,
    @DrawableRes val pressedResId: Int,
) {
    GREEN(
        color = PrimaryGreen,
        defaultResId = R.drawable.ic_ddeok_green_default,
        pressedResId = R.drawable.ic_ddeok_green_pressed,
    ),
    PINK(
        color = PrimaryPink,
        defaultResId = R.drawable.ic_ddeok_pink_default,
        pressedResId = R.drawable.ic_ddeok_pink_pressed,
    ),
    YELLOW(
        color = PrimaryYellow,
        defaultResId = R.drawable.ic_ddeok_yellow_default,
        pressedResId = R.drawable.ic_ddeok_yellow_pressed,
    )
}