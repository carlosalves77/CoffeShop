package com.carlos.coffeshopapp.model

data class FavoriteItems(
    val coffeeName: String,
    val coffeeComplement: String,
    val coffeePrice: String? = null,
    val coffeeImage: Int = 0,
)
