package com.carlos.coffeshopapp.dto

data class CoffeeItem(
    val description: String,
    val id: Int,
    val image: String,
    val ingredients: List<String>,
    val title: String
)