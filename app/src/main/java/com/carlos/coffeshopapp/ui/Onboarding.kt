package com.carlos.coffeshopapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.ui.theme.Orange

@Preview(device = "id:pixel_4")
@Composable
fun Onboarding() {
    val modifier = Modifier
    val isButtonEnabled = remember { mutableStateOf(true) }

    ConstraintLayout(
        modifier
            .fillMaxSize(1f)
            .background(Color.Black)

    ) {
        val (image, bottomColumn, boxText) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.onboarding),
            contentDescription = stringResource(
                id = R.string.onboarding_description
            ),
            modifier
                .fillMaxWidth()
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.FillWidth,

        )
        Box(
            modifier
                .constrainAs(boxText) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                })
        Column(
            modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .constrainAs(bottomColumn) {
                    top.linkTo(boxText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    end.linkTo(parent.end)
                }
        ) {
            Text(
                text = "Coffee so good, your taste buds will love it.",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier.size(10.dp))
            Text(
                text = "The best grain, the finest roast, the powerful flavor.",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
            Spacer(modifier.size(10.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                enabled = isButtonEnabled.value
            ) {
                Text(
                    text = "Get Start",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold

                )
            }
        }
    }

}