package com.carlos.coffeshopapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
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
import com.carlos.coffeshopapp.components.CustomCoffeeListItem
import com.carlos.coffeshopapp.components.CustomCoffeeTypeItem
import com.carlos.coffeshopapp.repository.CoffeeItemsRepository
import com.carlos.coffeshopapp.repository.CoffeeTypeRepository
import com.carlos.coffeshopapp.ui.theme.BackGroundColor
import com.carlos.coffeshopapp.ui.theme.GrandientBackFirst
import com.carlos.coffeshopapp.ui.theme.GrandientBackTwo
import com.carlos.coffeshopapp.ui.theme.GraySearchBarText
import com.carlos.coffeshopapp.ui.theme.LocationTextColor
import com.carlos.coffeshopapp.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Home() {
    val modifier = Modifier

    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    val coffeeType = remember { CoffeeTypeRepository.coffeeList }
    val coffeeList = remember { CoffeeItemsRepository.coffeeListItems }


    Column(
        modifier
            .fillMaxSize()
            .background(BackGroundColor)
    ) {

        Box(
            modifier
                .height(280.dp)
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            GrandientBackTwo,
                            GrandientBackFirst
                        )
                    )
                )
        ) {
            ConstraintLayout(
                modifier
                    .padding(24.dp)
            ) {

                val (locationText,
                    cityText,
                    imageProfile,
                    searchBar,
                    boxCard,
                    textCard,
                    textPromoCard,
                ) = createRefs()


                Text(
                    text = "Location",
                    modifier
                        .padding(top = 20.dp, start = 10.dp)
                        .constrainAs(locationText) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        },
                    fontFamily = FontFamily(Font(R.font.sora_regular, FontWeight(400))),
                    fontSize = 12.sp,
                    color = Color.Gray,
                )
                Spacer(modifier = modifier.padding(5.dp))
                Text(
                    text = "Bilzen, Tanjungbalai",
                    modifier
                        .padding(start = 10.dp)
                        .constrainAs(cityText) {
                            top.linkTo(locationText.bottom)
                            start.linkTo(parent.start)
                        },
                    color = LocationTextColor,
                    fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(800))),
                    fontSize = 14.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.profilepicture),
                    contentDescription = null,
                    modifier
                        .padding(top = 20.dp, end = 10.dp)
                        .size(44.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .constrainAs(imageProfile) {
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        },
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier.padding(10.dp))
                SearchBar(
                    query = text,
                    onQueryChange = {
                        text = it
                    },
                    onSearch = {
                        active = false
                    },
                    active = active,
                    onActiveChange = {
                        active = it
                    },
                    modifier
                        .constrainAs(searchBar) {
                            top.linkTo(cityText.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    tonalElevation = 0.dp,
                    shape = RoundedCornerShape(14.dp),
                    placeholder = {
                        Text(
                            text = "Search Coffe",
                            color = GraySearchBarText
                        )
                    },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = {
                        Box(
                            modifier
                                .background(
                                    color = Orange,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .size(44.dp)
                        ) {
                            Image(
                                painterResource(id = R.drawable.furnitur_icon),
                                contentDescription = null,
                                modifier
                                    .align(Alignment.Center)
                                    .size(24.dp),
                            )
                        }

                    }) {

                }
                ConstraintLayout(
                    modifier
                        .padding(top = 20.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(22.dp))
                        .size(width = 315.dp, height = 140.dp)
                        .constrainAs(boxCard) {
                            top.linkTo(searchBar.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.card_image),
                        contentDescription = "Image Card",
                        modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(22.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier
                            .padding(top = 15.dp, start = 23.dp)
                            .constrainAs(textPromoCard) {
                                top.linkTo(parent.top)
                                start.linkTo(parent.start)
                            }
                            .background(Color.Red, shape = RoundedCornerShape(13.dp))
                    ) {
                        Text(
                            text = "Promo",
                            modifier.padding(vertical = 5.dp, horizontal = 12.dp),
                            fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(600))),
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = "Buy one get\n one FREE",
                        modifier
                            .padding(start = 23.dp)
                            .constrainAs(textCard) {
                                top.linkTo(textPromoCard.bottom)
                                start.linkTo(parent.start)
                            },
                        fontSize = 32.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(600))),
                    )
                }
            }
        } // Box End
        ConstraintLayout(
            modifier
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            val (lazyRow, lazyColumnContainer, lazyColumn) = createRefs()
            LazyRow(
                modifier
                    .padding(top = 30.dp, start = 16.dp)
                    .constrainAs(lazyRow) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    },
                horizontalArrangement = Arrangement.spacedBy(4.dp)

            ) {
                itemsIndexed(items = coffeeType) { index, item ->
                    CustomCoffeeTypeItem(coffeeType = item,  selected = selectedIndex == index, clickAction = { selectedIndex = index })
                }
            }
            ConstraintLayout(
                modifier
                    .fillMaxSize()
                    .padding(top = 15.dp, start = 16.dp, end = 16.dp)
                    .constrainAs(lazyColumnContainer) {
                        top.linkTo(lazyRow.bottom)
                    }) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier.constrainAs(lazyColumn) {
                        top.linkTo(lazyRow.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    items(items = coffeeList, itemContent = {
                        CustomCoffeeListItem(coffeeItems = it)
                    })
                }
            }

        }

    }
}