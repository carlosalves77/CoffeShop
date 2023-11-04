package com.carlos.coffeshopapp.ui.HomeScreen

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.ui.HomeScreen.components.CustomCoffeeListItem
import com.carlos.coffeshopapp.ui.HomeScreen.components.CustomCoffeeTypeItem
import com.carlos.coffeshopapp.repository.CoffeeItemsRepository
import com.carlos.coffeshopapp.repository.CoffeeTypeRepository
import com.carlos.coffeshopapp.ui.theme.BackGroundColor
import com.carlos.coffeshopapp.ui.theme.GrandientBackFirst
import com.carlos.coffeshopapp.ui.theme.GrandientBackTwo
import com.carlos.coffeshopapp.ui.theme.GraySearchBarText
import com.carlos.coffeshopapp.ui.theme.LocationTextColor
import com.carlos.coffeshopapp.ui.theme.Orange

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavController) {

    val activity = LocalContext.current as Activity

    val modifier = Modifier

    BackHandler {
        activity.finish()
    }

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

        Column(
            modifier
                .height(280.dp)
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            GrandientBackTwo,
                            GrandientBackFirst
                        )
                    )
                )
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, start = 30.dp, end = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Localização",
                        fontFamily = FontFamily(Font(R.font.sora_regular, FontWeight(400))),
                        fontSize = 12.sp,
                        color = Color.Gray,
                    )

                    Text(
                        text = "Recife, Pernambuco",
                        color = LocationTextColor,
                        fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(800))),
                        fontSize = 14.sp
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.profilepicture),
                    contentDescription = null,
                    modifier
                        .size(44.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            DockedSearchBar(
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
                    .padding(top = 28.dp, start = 30.dp, end = 30.dp)
                ,
                tonalElevation = 0.dp,
                shape = RoundedCornerShape(14.dp),
                placeholder = {
                    Text(
                        text = "Procurar café",
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

                },
            ) {

            }

        } // Box End
        Column(
            modifier
                .fillMaxSize()
        ) {
            Box(
                modifier
                    .offset(0.dp, (-70).dp)
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(22.dp))
                    .height(140.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.card_image),
                    contentDescription = "Image Card",
                    modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(22.dp)),
                    contentScale = ContentScale.Crop
                )
                Column() {
                    Box(
                        modifier
                            .padding(top = 13.dp, start = 23.dp)
                            .background(Color.Red, shape = RoundedCornerShape(13.dp))
                            .zIndex(2f)
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
                        text = "Compre um\noutro de graça",
                        modifier.padding(start = 24.dp),
                        fontSize = 32.sp,
                        fontFamily = FontFamily(Font(R.font.sora_bold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFFFFFFF),
                    )
                }
            }
            LazyRow(
                modifier
                    .padding(start = 30.dp)
                    .offset(0.dp, (-40).dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                itemsIndexed(items = coffeeType) { index, item ->
                    CustomCoffeeTypeItem(
                        coffeeType = item,
                        selected = selectedIndex == index,
                        clickAction = { selectedIndex = index })
                }
            }
            Column(
                modifier
                    .fillMaxSize()
                    .padding(top = 15.dp, start = 30.dp, end = 30.dp)
                    .offset(0.dp, (-40).dp)
                ,
            ) {

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    items(items = coffeeList, itemContent = {
                        CustomCoffeeListItem(coffeeItems = it, navController)
                    })
                }
            }
        }

    }



}


