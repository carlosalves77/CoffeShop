package com.carlos.coffeshopapp.ui.BagScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
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
import com.carlos.coffeshopapp.model.BagItems


@Composable
fun CustomCartListItem(bagItems: BagItems) {
    val modifier = Modifier

    val value = remember { mutableIntStateOf(1) }
    if (value.intValue < 1) value.intValue = 1


    Row (
        modifier
            .shadow(
                elevation = 40.dp,
                spotColor = Color(0x08000000),
                ambientColor = Color(0x08000000)
            )
            .fillMaxWidth()
            .height(102.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 20.dp)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = bagItems.coffeeImage),
            contentDescription = "image description",
            modifier
                .padding(start = 17.dp)
                .size(69.dp)
                .clip(CircleShape)
            ,
            contentScale = ContentScale.FillBounds,
        )
        Column (
            modifier
                .padding(top = 20.dp, start = 14.dp, end = 20.dp)
                .fillMaxHeight()
        ) {
            Text(
                text = bagItems.coffeeName,
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.sora_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    textAlign = TextAlign.Center,

            )
            Text(
                text = bagItems.coffeeComplement,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sora_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF9B9B9B),

            )
        }
        Column(
            modifier
                .padding(18.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Row (
                modifier
                    .width(72.dp)
                    .height(30.dp)
                    .background(color = Color(0xFFC67C4E), shape = RoundedCornerShape(size = 30.dp)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "-",
                    modifier.clickable (indication = null,interactionSource = MutableInteractionSource()) {
                        value.intValue--
                    },
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.sora_medium)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFF4F4F7),
                        textAlign = TextAlign.Center,
                )
                Text(
                    text = "${value.intValue}",
                    fontSize = 20.sp,
                    fontFamily = FontFamily(Font(R.font.sora_medium)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFFF4F4F7),
                    textAlign = TextAlign.Center,

                    )
                Text(
                    text = "+",
                    modifier.clickable (indication = null,interactionSource = MutableInteractionSource()) {
                       value.intValue++
                    },
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.sora_medium)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFFF4F4F7),
                    textAlign = TextAlign.Center,

                    )

            }


        }

    }
}