package com.carlos.coffeshopapp.repository

import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.model.CoffeeItems

object CoffeeItemsRepository  {


    val coffeeListItems = listOf(
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Chocolate",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 4.53",
            coffeeStars = "4.8"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Vanilla",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 4.95",
            coffeeStars = "4.9"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Caramel",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 3.99",
            coffeeStars = "4.0"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Hazelnut",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 4.53",
            coffeeStars = "4.4"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Hazelnut",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 4.75",
            coffeeStars = "4.8"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Whipped Cream",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 5.25",
            coffeeStars = "4.2"
        )
    )



}