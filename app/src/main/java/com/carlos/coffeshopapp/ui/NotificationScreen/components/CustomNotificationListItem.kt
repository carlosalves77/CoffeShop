package com.carlos.coffeshopapp.ui.NotificationScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlos.coffeshopapp.R

@Preview(showBackground = true)
@Composable
fun CustomNotificationListItem() {
    val modifier = Modifier

    Row(
        modifier
            .shadow(
                elevation = 40.dp,
                spotColor = Color(0x08000000),
                ambientColor = Color(0x08000000)
            )
            .fillMaxWidth()
            .height(102.dp)
            .background(color = Color(0xFFFFFFFF)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.c1),
            contentDescription = "image description",
            modifier
                .padding(start = 17.dp)
                .size(69.dp)
                .clip(RoundedCornerShape(14.dp)),
            contentScale = ContentScale.FillBounds,
        )
        Column(
            modifier
                .padding(top = 20.dp, start = 14.dp, end = 20.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = "Volte a economizar",
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.sora_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,

                )
            Spacer(modifier.height(10.dp))
            Column (
                modifier
                    .width(200.dp)
            ) {
            Text(
                text = "Eu ouvi cashback?",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sora_medium)),
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                )
            }
        }
        Column(
            modifier
                .padding(18.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "08/11",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.sora_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFFC67C4E)
            )

        }

    }
}