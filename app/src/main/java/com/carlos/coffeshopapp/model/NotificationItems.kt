package com.carlos.coffeshopapp.model

data class NotificationItems(
    val notificationName: String,
    val notificationComplement: String,
    val notificationDate: String,
    val notificationImage: Int = 0,
)
