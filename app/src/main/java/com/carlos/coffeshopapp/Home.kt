package com.carlos.coffeshopapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.carlos.coffeshopapp.ui.theme.GrandientBackFirst
import com.carlos.coffeshopapp.ui.theme.GrandientBackTwo
import com.carlos.coffeshopapp.ui.theme.GraySearchBarText
import com.carlos.coffeshopapp.ui.theme.Orange


@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = "id:pixel_4")
@Composable
fun Home() {
    val modifier = Modifier

    var text by remember {
        mutableStateOf("")
    }
    var active by remember {
        mutableStateOf(false)
    }

    ConstraintLayout(modifier.fillMaxSize()) {
        val (locationText, cityText, imageProfile, searchBar) = createRefs()
        Box(
            modifier
                .fillMaxWidth()
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
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                Text(
                    text = "Location",
                    modifier
                        .padding(top = 20.dp, start = 10.dp)
                        .constrainAs(locationText) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                        },
                    fontSize = 16.sp,
                    color = Color.Gray,
                )
                Spacer(modifier = modifier.padding(5.dp))
                Text(
                    text = "Recife, Pernambuco",
                    modifier
                        .padding(start = 10.dp)
                        .constrainAs(cityText) {
                            top.linkTo(locationText.bottom)
                            start.linkTo(parent.start)
                        },
                    color = Color.White,
                    fontWeight = FontWeight(800),
                    fontSize = 18.sp
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
                        .padding(top = 10.dp)
                        .constrainAs(searchBar) {
                            top.linkTo(cityText.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
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
                                .background(color = Orange)
                                .clip(shape = RoundedCornerShape(16.dp)
                                ).size(44.dp)


                        ) {

                        }

                    }) {

                }
            }
        }
    }
}