package com.carlos.coffeshopapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.ui.theme.BackGroundColor
import com.carlos.coffeshopapp.ui.theme.CoffeeNamePlusList
import com.carlos.coffeshopapp.ui.theme.IconColor
import com.carlos.coffeshopapp.ui.theme.starColor

@Preview(device = "id:pixel_4")
@Composable
fun DetailScreen() {

    val modifier = Modifier

    var onClickFavorite by remember {
        mutableStateOf(false)
    }

    Column(
        modifier
            .fillMaxSize()
            .background(BackGroundColor)
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(top = 55.dp, start = 24.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "BackButton",
                modifier
                    .size(38.dp)
                    .clickable { },
                tint = IconColor,
            )
            Text(
                text = "Detail",
                fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(800))),
                color = IconColor,
                fontSize = 22.sp

            )
            Icon(
                if (onClickFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = "Heart",
                modifier
                    .size(34.dp)
                    .background(Color.Transparent)
                    .clickable {

                        onClickFavorite = !onClickFavorite
                    },
                tint = if (onClickFavorite) Color.Red else IconColor,
            )
        }
        Box(
            modifier
                .padding(top = 20.dp, start = 24.dp, end = 24.dp)
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .background(Color.Black)
                .height(226.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.detailcoffeimage),
                contentDescription = "Coffee Detail",
                modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        ConstraintLayout(
            modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            val (txtTitle, complementCoffeeTxt, ratingRow) = createRefs()

            Text(
                text = "Cappuccino",
                modifier
                    .padding(top = 15.dp)
                    .constrainAs(txtTitle) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(600))),
                color = IconColor,
                fontSize = 20.sp
            )
            Text(
                text = "with Chocolate",
                modifier
                    .padding(top = 5.dp, start = 1.dp)
                    .constrainAs(complementCoffeeTxt) {
                        top.linkTo(txtTitle.bottom)
                        start.linkTo(parent.start)
                    },
                color = CoffeeNamePlusList,
                fontFamily = FontFamily(Font(R.font.sora_regular, FontWeight(400))),
                fontSize = 12.sp
            )
            Row(
                modifier
                    .width(96.dp)
                    .constrainAs(ratingRow) {
                        top.linkTo(complementCoffeeTxt.bottom)
                        start.linkTo(parent.start)
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = "Star",
                    modifier.size(24.dp),
                    tint = starColor,
                )
                Text(
                    text = "4.8",
                    fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(400))),
                    color = IconColor,
                    fontSize = 20.sp
                )
                Text(
                    text = "(230)",
                    modifier.padding(top = 4.dp),
                    color = CoffeeNamePlusList,
                    fontFamily = FontFamily(Font(R.font.sora_regular, FontWeight(400))),
                    fontSize = 12.sp
                )

            }
        }
    }

}