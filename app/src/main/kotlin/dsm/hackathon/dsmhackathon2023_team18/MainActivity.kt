package dsm.hackathon.dsmhackathon2023_team18

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dsm.hackathon.dsmhackathon2023_team18.domain.PrimaryDdeok
import dsm.hackathon.dsmhackathon2023_team18.ui.auth.AuthDestination
import dsm.hackathon.dsmhackathon2023_team18.ui.auth.authNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.mainNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.DSMHackathon2023Team18Theme

val LocalPrimaryColor = staticCompositionLocalOf<Color> { error("not initialized") }
val LocalPrimaryDdeok = staticCompositionLocalOf<PrimaryDdeok> { error("not initialized") }

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
            setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val primaryDdeok = PrimaryDdeok.GREEN //.values().random()

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
                startDestination = AuthDestination.route,
                enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start) },
                exitTransition = { fadeOut(tween(delayMillis = 10)) },
                popEnterTransition = { EnterTransition.None },
                popExitTransition = {
                    slideOutOfContainer(
                        towards = AnimatedContentTransitionScope.SlideDirection.End,
                        animationSpec = tween(delayMillis = 10),
                    )
                },
            ) {
                mainNavigation(navController)
                authNavigation(navController)
            }
        }
    }
}
