package com.carlos.coffeshopapp.ui.FavoriteScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.repository.FavoritesItemsRepository
import com.carlos.coffeshopapp.ui.FavoriteScreen.components.CustomFavoriteListItem
import com.carlos.coffeshopapp.ui.theme.BackGroundColor
import com.carlos.coffeshopapp.ui.theme.IconColor

@Composable
fun FavoriteScreen(navController: NavController) {

    val modifier = Modifier

    BackHandler {
        navController.navigate("BottomNavigation")
    }

    val favoriteItemsList = remember { FavoritesItemsRepository.favoriteListItems }

    Column(
        modifier
            .fillMaxSize()
            .background(BackGroundColor),
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
                            navController.navigate("BottomNavigation")
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
        LazyColumn(
            modifier.padding(bottom = 120.dp),
            contentPadding = PaddingValues(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(items = favoriteItemsList, itemContent = {
                CustomFavoriteListItem(favoriteItems = it)
            })
        }



    }
}