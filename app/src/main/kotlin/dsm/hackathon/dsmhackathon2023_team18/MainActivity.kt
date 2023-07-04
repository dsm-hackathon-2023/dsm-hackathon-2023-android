package dsm.hackathon.dsmhackathon2023_team18

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dsm.hackathon.dsmhackathon2023_team18.ui.auth.authNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.MainDestination
import dsm.hackathon.dsmhackathon2023_team18.ui.main.mainNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.DSMHackathon2023Team18Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        )
        window.statusBarColor = Color.Transparent.toArgb()
        window.navigationBarColor = Color.Transparent.toArgb()

        window.isNavigationBarContrastEnforced = false

        setContent {
            OnuiApp()
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
                mainNavigation()
                authNavigation()
            }
        }
    }
}
