package com.carlos.coffeshopapp.repository

import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.model.CoffeeItems

object CoffeeItemsRepository  {


    val coffeeListItems = listOf(
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Chocolate",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 4.53"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Vanilla",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 4.95"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Caramel",
            coffeeImage = R.drawable.c3,
            coffeePrice = "$ 3.99"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Hazelnut",
            coffeeImage = R.drawable.c4,
            coffeePrice = "$ 4.53"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Hazelnut",
            coffeeImage = R.drawable.c3,
            coffeePrice = "$ 4.75"
        ),
        CoffeeItems(
            coffeeName = "Capppucino",
            coffeeComplement = "with Whipped Cream",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 5.25"
        )
    )



}