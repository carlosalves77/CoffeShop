package com.carlos.coffeshopapp.repository

import com.carlos.coffeshopapp.model.CoffeeType

object CoffeeTypeRepository  {


    val coffeeList = listOf(
        CoffeeType(
            coffeeTypeName = "Cappuccino"
        ),
        CoffeeType(
            coffeeTypeName = "Machiato"
        ),
        CoffeeType(
            coffeeTypeName = "Latte"
        ),
        CoffeeType(
            coffeeTypeName = "Arrusk"
        )
    )

}