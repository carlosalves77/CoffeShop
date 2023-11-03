package com.carlos.coffeshopapp.ui.BottomNavigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.carlos.coffeshopapp.ui.FavoriteScreen.FavoriteScreen
import com.carlos.coffeshopapp.ui.HomeScreen.Home
import com.carlos.coffeshopapp.ui.theme.Orange

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigation(
    navController: NavHostController
) {

    val modifier = Modifier

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }


    var selectedScreen by remember {
        mutableIntStateOf(0)
    }

//
//    val colors = NavigationBarItemDefaults.colors(
//        selectedIconColor = Color(0xFFC67C4E),
//        unselectedIconColor = Color(0xFF8D8D8D),
//        indicatorColor = if (selectedItemIndex == index) Color.White else Color.White,
//        unselectedTextColor = Color.White,
//        disabledIconColor = Color.Red,
//        disabledTextColor = Color.Transparent,
//    )

    Scaffold(bottomBar = {
        NavigationBar(
            modifier
                .clip(RoundedCornerShape(size = 24.dp))
                .width(375.dp)
                .shadow(
                    elevation = 24.dp,
                    spotColor = Color(0x40E4E4E4),
                    ambientColor = Color(0x40E4E4E4)
                ),
            containerColor = Color.White,
            tonalElevation = 24.dp,
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        selectedItemIndex = index
                        selectedScreen = index
                    },
                    label = {

                        Icon(
                            painter = painterResource(id = item.underSelectedICon),
                            contentDescription = "Icons",
                            modifier
                                .size(18.dp),
                            tint = if (index == selectedItemIndex) Color(0xFFC67C4E) else Color.White
                        )

                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon),
                            contentDescription = "Icons",
                            modifier
                                .weight(3f)
                                .size(24.dp)
                        )

                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFC67C4E),
                        unselectedIconColor = Color(0xFF8D8D8D),
                        indicatorColor = Color.White,
                        unselectedTextColor = Color.White,
                        disabledIconColor = Color.White,
                        disabledTextColor = Color.White,
                    )


                )

            }
        }
    }) {
        when (selectedScreen) {
            0 -> {
                Home(navController = navController)
            }

            1 -> {
                FavoriteScreen()
            }

            2 -> {

            }

            3 -> {

            }
        }

    }

}