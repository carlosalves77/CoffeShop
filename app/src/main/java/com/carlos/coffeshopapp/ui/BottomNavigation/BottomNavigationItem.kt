package com.carlos.coffeshopapp.ui.BottomNavigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val underSelectedICon: Int,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val hasNews: Boolean,
)
