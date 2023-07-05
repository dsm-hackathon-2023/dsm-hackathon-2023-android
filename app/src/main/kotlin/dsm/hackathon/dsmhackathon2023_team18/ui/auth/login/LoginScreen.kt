package dsm.hackathon.dsmhackathon2023_team18.ui.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import dsm.hackathon.dsmhackathon2023_team18.LocalPrimaryColor
import dsm.hackathon.dsmhackathon2023_team18.R
import dsm.hackathon.dsmhackathon2023_team18.ui.util.SocialIconButton

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onNavigateToMainNav: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(LocalPrimaryColor.current)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Spacer(modifier = Modifier.height(128.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_onui_logo),
            contentDescription = null,
            tint = Color.White,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(color = Color.White)) {
                    append("오늘 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("누군가")
                    }
                    append("의 이야기,\n오늘의 ")
                    withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                        append("감정")
                    }
                    append("은 어떠신가요?")
                }
            },
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(1f))
        GlideImage(imageModel = { R.drawable.gif_ddeok })
        Spacer(modifier = Modifier.weight(1f))
        SocialIconButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.ic_google),
            text = "Google 계정으로 시작하기",
            onClick = onNavigateToMainNav,
        )
        SocialIconButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.ic_naver),
            text = "Naver 계정으로 시작하기",
            onClick = onNavigateToMainNav,
        )
        SocialIconButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            painter = painterResource(id = R.drawable.ic_kakao_talk),
            text = "Kakao 계정으로 시작하기",
            onClick = onNavigateToMainNav,
        )
        Spacer(modifier = Modifier.height(48.dp))
    }
}
