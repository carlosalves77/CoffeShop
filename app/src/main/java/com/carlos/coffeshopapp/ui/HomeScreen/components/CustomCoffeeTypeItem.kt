package com.carlos.coffeshopapp.ui.HomeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlos.coffeshopapp.model.CoffeeType
import com.carlos.coffeshopapp.ui.theme.LazyRawText
import com.carlos.coffeshopapp.ui.theme.Orange


@Composable
fun CustomCoffeeTypeItem(coffeeType: CoffeeType, selected: Boolean = false, clickAction: () -> Unit) {
    Row(
        modifier = Modifier
            .size(width = 121.dp, height = 38.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { clickAction() }
            .background(if (selected) Orange else Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ) {
        Text(
            text = coffeeType.coffeeTypeName,
            color = if (selected) Color.White else LazyRawText,
            fontWeight = FontWeight(600),
            fontSize = 14.sp
        )
    }
}