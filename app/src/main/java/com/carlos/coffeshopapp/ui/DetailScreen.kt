package com.carlos.coffeshopapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
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
import androidx.core.view.KeyEventDispatcher.Component
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.model.SizeButton
import com.carlos.coffeshopapp.ui.theme.BackGroundColor
import com.carlos.coffeshopapp.ui.theme.BoxIconDetail
import com.carlos.coffeshopapp.ui.theme.CoffeeNamePlusList
import com.carlos.coffeshopapp.ui.theme.DescriptionText
import com.carlos.coffeshopapp.ui.theme.IconColor
import com.carlos.coffeshopapp.ui.theme.RowLine
import com.carlos.coffeshopapp.ui.theme.SizeButton
import com.carlos.coffeshopapp.ui.theme.onSizeButtonBackGroundClick
import com.carlos.coffeshopapp.ui.theme.onSizeButtonClick
import com.carlos.coffeshopapp.ui.theme.starColor

@Preview(device = "id:pixel_4")
@Composable
fun DetailScreen() {

    val modifier = Modifier

    var onClickFavorite by remember {
        mutableStateOf(false)
    }

    var isButtonSizeActivate by remember {
        mutableStateOf(false)
    }


    val buttonSizeList = listOf(
        "S", "M", "L"
    )

    val interactionSource = remember {
        MutableInteractionSource()
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
                    .clickable(indication = null, interactionSource = interactionSource) {

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

            val (
                txtTitle,
                complementCoffeeTxt,
                ratingRow,
                boxDetailIcon,
                row,
                descriptionTxt,
                descriptionResumeText,
                sizeText,
                rowSizeContainer
            ) = createRefs()

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
                    .padding(top = 5.dp)
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

            Row(
                modifier
                    .padding(top = 60.dp)
                    .width(100.dp)
                    .constrainAs(boxDetailIcon) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    },
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Box(
                    modifier
                        .size(44.dp)
                        .background(BoxIconDetail, RoundedCornerShape(14.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.coffeeicon),
                        contentDescription = "Coffee Icon",
                        modifier
                            .size(24.dp)
                            .fillMaxSize()
                            .align(Center)

                    )
                }
                Box(
                    modifier
                        .size(44.dp)
                        .background(BoxIconDetail, RoundedCornerShape(14.dp)),

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.milkdetailicon),
                        contentDescription = "Coffee Icon",
                        modifier
                            .size(24.dp)
                            .fillMaxSize()
                            .align(Center)

                    )

                }

            }
            Spacer(
                modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .height(1.dp)
                    .background(RowLine)
                    .constrainAs(row)
                    {
                        top.linkTo(ratingRow.bottom)
                        start.linkTo(parent.start)
                    })

            Text(
                text = "Description",
                modifier
                    .padding(top = 15.dp)
                    .constrainAs(descriptionTxt) {
                        top.linkTo(row.bottom)
                        start.linkTo(parent.start)
                    },
                fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(600))),
                color = IconColor,
                fontSize = 20.sp
            )
            Text(
                text = "A cappuccino is an approximately 150 ml (5 oz) beverage, with 25 ml of espresso coffee and 85ml of fresh milk the fo.. Read More",
                modifier
                    .padding(top = 15.dp)
                    .constrainAs(descriptionResumeText) {
                        top.linkTo(descriptionTxt.bottom)
                        start.linkTo(parent.start)
                    },
                fontFamily = FontFamily(Font(R.font.sora_regular, FontWeight(600))),
                color = DescriptionText,
                fontSize = 16.sp
            )
            Text(
                text = "Size",
                modifier
                    .padding(top = 10.dp)
                    .constrainAs(sizeText) {
                        top.linkTo(descriptionResumeText.bottom)
                        start.linkTo(parent.start)
                    },
                fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(600))),
                color = IconColor,
                fontSize = 20.sp
            )
            Row (
                modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .constrainAs(rowSizeContainer) {
                        top.linkTo(sizeText.bottom)
                        start.linkTo(parent.start)
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                buttonSizeList.forEachIndexed { index, component ->

                    Row (
                        modifier
                            .border(
                                border = BorderStroke(
                                    1.dp,
                                    if (isButtonSizeActivate) onSizeButtonClick else SizeButton
                                ),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .size(96.dp, 43.dp)
                            .background(if (isButtonSizeActivate) onSizeButtonBackGroundClick else Color.White)
                            .clickable(indication = null, interactionSource = interactionSource) {
                                isButtonSizeActivate = !isButtonSizeActivate

                            }
                        ,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = component,
                            fontFamily = FontFamily(Font(R.font.sora_regular, FontWeight(400))),
                            color = if (isButtonSizeActivate) onSizeButtonClick else IconColor,
                            fontSize = 14.sp
                        )
                    }

                }
            }

        }
    }

}