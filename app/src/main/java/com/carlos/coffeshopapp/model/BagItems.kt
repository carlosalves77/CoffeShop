package com.carlos.coffeshopapp.model

data class BagItems(
    val coffeeName: String,
    val coffeeComplement: String,
    val coffeePrice: String? = null,
    val coffeeImage: Int = 0,
)


