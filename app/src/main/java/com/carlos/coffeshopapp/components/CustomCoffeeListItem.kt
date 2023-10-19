package com.carlos.coffeshopapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.model.CoffeeItems
import com.carlos.coffeshopapp.ui.theme.ValidationContent
import com.carlos.coffeshopapp.ui.theme.CoffeeNameList
import com.carlos.coffeshopapp.ui.theme.CoffeeNamePlusList
import com.carlos.coffeshopapp.ui.theme.CoffeePriceList
import com.carlos.coffeshopapp.ui.theme.Orange


@Composable
fun CustomCoffeeListItem(coffeeItems: CoffeeItems) {

    val modifier = Modifier
    Column(
        modifier
            .size(width = 149.dp, height = 239.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White),
    ) {
        Column(
            modifier.fillMaxWidth(),
            horizontalAlignment = CenterHorizontally
        ) {
            Box(modifier.padding(4.dp)) {
                // TODO - Avaliation starts
//            Row(
//                modifier
//                    .background(ValidationContent)
//                    .clip(RoundedCornerShape(16.dp))
//                    .size(width = 51.dp, height = 25.dp)) {
//
//            }
                Image(
                    painter = painterResource(id = coffeeItems.coffeeImage),
                    contentDescription = "Coffee",
                    modifier
                        .size(width = 141.dp, height = 132.dp)
                )
            }
        }
        Column(modifier.padding(top = 5.dp, start = 10.dp, end = 5.dp)) {
            Text(
                text = coffeeItems.coffeeName,
                fontWeight = FontWeight(600),
                fontSize = 16.sp,
                color = CoffeeNameList,
            )
            Spacer(modifier.padding(top = 2.dp))
            Text(
                text = coffeeItems.coffeeComplement,
                color = CoffeeNamePlusList,
                fontWeight = FontWeight(400),
                fontSize = 12.sp
            )
            Spacer(modifier.padding(top = 10.dp))
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = coffeeItems.coffeePrice,
                    fontWeight = FontWeight(600),
                    color = CoffeePriceList,
                    fontSize = 18.sp
                )
                Box(
                    modifier
                        .background(
                            color = Orange,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(32.dp),
                    contentAlignment = Center
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                        modifier.size(16.dp),
                        tint = Color.White
                    )
                }

            }

        }

    }


}