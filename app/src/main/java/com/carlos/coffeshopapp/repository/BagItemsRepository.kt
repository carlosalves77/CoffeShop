package com.carlos.coffeshopapp.repository

import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.model.BagItems
import com.carlos.coffeshopapp.model.CoffeeItems

object BagItemsRepository  {


    val bagListItems = listOf(
        BagItems(
            coffeeName = "Capppucino",
            coffeeComplement = "Com Chocolate",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 4.53",

        ),
        BagItems(
            coffeeName = "Capppucino",
            coffeeComplement = "Com Vanilla",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 4.95",
        ),
        BagItems(
            coffeeName = "Capppucino",
            coffeeComplement = "Com Caramelo",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 3.99",

        ),
        BagItems(
            coffeeName = "Capppucino",
            coffeeComplement = "Com Avelã",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 4.53",
        ),
        BagItems(
            coffeeName = "Capppucino",
            coffeeComplement = "Com Caramelo",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 4.75",

        ),
        BagItems(
            coffeeName = "Capppucino",
            coffeeComplement = "Com Chantilly",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 5.25",

        )
    )



}