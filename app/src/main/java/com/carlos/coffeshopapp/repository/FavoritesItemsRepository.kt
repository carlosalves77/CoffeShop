package com.carlos.coffeshopapp.repository

import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.model.BagItems
import com.carlos.coffeshopapp.model.CoffeeItems
import com.carlos.coffeshopapp.model.FavoriteItems

object FavoritesItemsRepository  {


    val favoriteListItems = listOf(
        FavoriteItems(
            coffeeName = "Capppucino",
            coffeeComplement = "Com Chocolate",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 4.53",

        ),
        FavoriteItems(
            coffeeName = "Latte",
            coffeeComplement = "Com Vanilla",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 4.95",
        ),
        FavoriteItems(
            coffeeName = "Capppucino",
            coffeeComplement = "Com Caramelo",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 3.99",

        ),
        FavoriteItems(
            coffeeName = "Machiato",
            coffeeComplement = "Com Avelã",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 4.53",
        ),
        FavoriteItems(
            coffeeName = "Lait",
            coffeeComplement = "Com Caramelo",
            coffeeImage = R.drawable.c1,
            coffeePrice = "$ 4.75",

        ),
        FavoriteItems(
            coffeeName = "Machiato",
            coffeeComplement = "Com Chantilly",
            coffeeImage = R.drawable.c2,
            coffeePrice = "$ 5.25",

        )
    )



}