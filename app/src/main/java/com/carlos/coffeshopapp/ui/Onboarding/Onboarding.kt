package com.carlos.coffeshopapp.ui.Onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.carlos.coffeshopapp.R


@Composable
fun Onboarding(navController: NavController) {


    val modifier = Modifier

    Column(
        modifier
            .fillMaxSize(1f)
            .verticalScroll(rememberScrollState())
            .background(Color.Black)

    ) {
        Image(
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = stringResource(
                id = R.string.onboarding_description
            ),
            modifier
                .fillMaxWidth(),
            contentScale = ContentScale.FillWidth

        )
        Column(
            modifier
                .offset(0.dp, (-50).dp)
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = "Café tão bom, que seu paladar vai adorar.",
                fontSize = 34.sp,
                fontFamily = FontFamily(Font(R.font.sora_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                letterSpacing = 0.34.sp,
            )
            Spacer(modifier.size(10.dp))
            Text(
                text = "O melhor grão, a torra mais fina, o sabor poderoso.",
                fontSize = 14.sp,
                lineHeight = 21.56.sp,
                fontFamily = FontFamily(Font(R.font.sora_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFFA9A9A9),
                textAlign = TextAlign.Center,
                letterSpacing = 0.14.sp,
            )
            Spacer(modifier.size(10.dp))
            Row(
                modifier
                    .padding(start = 30.dp, end = 30.dp)
                    .fillMaxWidth()
                    .height(62.dp)
                    .clickable {
                    navController.navigate("BottomNavigation")
                    }
                    .background(
                        color = Color(0xFFC67C4E),
                        shape = RoundedCornerShape(size = 16.dp)
                    ),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Vamos começar",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sora_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                )
            }

        }
    }

}