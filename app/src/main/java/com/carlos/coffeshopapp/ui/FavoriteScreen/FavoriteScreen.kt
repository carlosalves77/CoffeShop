package com.carlos.coffeshopapp.ui.FavoriteScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.ui.theme.IconColor

@Composable
fun FavoriteScreen() {

    val modifier = Modifier

    Column(
        modifier
            .fillMaxSize()
            .background(Color.White),
        ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(top = 55.dp, start = 24.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ConstraintLayout(modifier.fillMaxWidth()) {
                val (icon, text) = createRefs()
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "BackButton",
                    modifier
                        .size(38.dp)
                        .clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) {
//                            navController.navigate("BottomNavigation")
                        }
                        .constrainAs(icon) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                    tint = IconColor
                )
                Text(
                    text = "Favoritos",
                    modifier.constrainAs(text) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    },
                    fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(800))),
                    color = IconColor,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier.height(30.dp))




    }
}