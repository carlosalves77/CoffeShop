package com.carlos.coffeshopapp.ui.BottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import com.carlos.coffeshopapp.R


val items = listOf(
    BottomNavigationItem(
        underSelectedICon = R.drawable.retangle,
        selectedIcon = R.drawable.homeicon,
        unselectedIcon = R.drawable.homeiconoutline,
        hasNews = false,
    ),
    BottomNavigationItem(
        underSelectedICon = R.drawable.retangle,
        selectedIcon = R.drawable.hearticon,
        unselectedIcon = R.drawable.hearticonoutline,
        hasNews = false
    ),
    BottomNavigationItem(
        underSelectedICon = R.drawable.retangle,
        selectedIcon = R.drawable.bagicon,
        unselectedIcon = R.drawable.bagiconoutline,
        hasNews = false
    ),
    BottomNavigationItem(
        underSelectedICon = R.drawable.retangle,
        selectedIcon = R.drawable.notificationicon,
        unselectedIcon = R.drawable.notificationiconoutline,
        hasNews = false
    ),

)