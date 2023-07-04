package dsm.hackathon.dsmhackathon2023_team18

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dsm.hackathon.dsmhackathon2023_team18.ui.auth.authNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.MainDestination
import dsm.hackathon.dsmhackathon2023_team18.ui.main.mainNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.DSMHackathon2023Team18Theme
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.PrimaryGreen
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.PrimaryPink
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.PrimaryYellow

val LocalPrimaryColor = staticCompositionLocalOf<Color> { error("not initialized") }
private val primaryColors = listOf(PrimaryGreen, PrimaryPink, PrimaryYellow)
val LocalPrimaryDdeok = staticCompositionLocalOf<Ddeok> { error("not initialized") }

enum class Ddeok(
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.run {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            )
            statusBarColor = Color.Transparent.toArgb()
            navigationBarColor = Color.Transparent.toArgb()
            isNavigationBarContrastEnforced = false
        }

        val primaryDdeok = Ddeok.values().random()

        setContent {
            CompositionLocalProvider(
                LocalPrimaryColor provides primaryDdeok.color,
                LocalPrimaryDdeok provides primaryDdeok,
            ) {
                OnuiApp()
            }
        }
    }
}

@Composable
fun OnuiApp() {
    DSMHackathon2023Team18Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF5F0EF),
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = MainDestination.route,
            ) {
                mainNavigation(navController)
                authNavigation()
            }
        }
    }
}
