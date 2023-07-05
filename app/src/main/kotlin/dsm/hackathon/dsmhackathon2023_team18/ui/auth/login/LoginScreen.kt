package dsm.hackathon.dsmhackathon2023_team18.ui.auth.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryColor
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.util.SocialIconButton

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    onNavigateToMainNav: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(128.dp))
        Text(
            text = "오누이",
            color = LocalPrimaryColor.current,
            style = MaterialTheme.typography.displayMedium,
        )
        Spacer(modifier = Modifier.weight(1f))
        SocialIconButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.ic_google),
            text = "Google 계정으로 시작하기",
            onClick = onNavigateToMainNav,
        )
    }
}
