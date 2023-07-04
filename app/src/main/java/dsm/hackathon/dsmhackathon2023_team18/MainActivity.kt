package dsm.hackathon.dsmhackathon2023_team18

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dsm.hackathon.dsmhackathon2023_team18.ui.auth.AuthDestination
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
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = AuthDestination.route,
        ) {
            mainNavigation()
        }
    }
}
