package dsm.hackathon.dsmhackathon2023_team18

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dsm.hackathon.dsmhackathon2023_team18.ui.auth.authNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.main.MainDestination
import dsm.hackathon.dsmhackathon2023_team18.ui.main.mainNavigation
import dsm.hackathon.dsmhackathon2023_team18.ui.theme.DSMHackathon2023Team18Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DSMHackathon2023Team18Theme {
                OnuiApp()
            }
        }
    }
}

@Composable
fun OnuiApp() {
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
