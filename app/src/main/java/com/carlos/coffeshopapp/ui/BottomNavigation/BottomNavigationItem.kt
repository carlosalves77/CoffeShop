package com.carlos.coffeshopapp.ui.BottomNavigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val underSelectedICon: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val page: String? = null
)
