package com.carlos.coffeshopapp.repository

import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.model.NotificationItems

object NotificationItemsRepository {

    val notificationListItems = listOf(
        NotificationItems(
            notificationName = "Promoção Especial de Café",
            notificationComplement = "Desconto de 20% em todas as bebidas de café hoje!",
            notificationDate = "06/11",
            notificationImage = R.drawable.c1
        ),
        NotificationItems(
            notificationName = "Frete Grátis no Café!",
            notificationComplement = "Frete grátis no café da manhã!",
            notificationDate = "10/11",
            notificationImage = R.drawable.c2
        ),
        NotificationItems(
            notificationName = "Novo Café Especial!",
            notificationComplement = "Novo café especial no cardápio!",
            notificationDate = "15/11",
            notificationImage = R.drawable.c3

        ),
        NotificationItems(
            notificationName = "Café Gelado Especial!",
            notificationComplement = "Café gelado com brinde especial!",
            notificationDate = "20/11",
            notificationImage = R.drawable.c4
        ),
        NotificationItems(
            notificationName = "Café e Bolo: 25% de Desconto!",
            notificationComplement = "Economize 25% combinando café e bolo!",
            notificationDate = "25/11",
            notificationImage = R.drawable.c1

        ),
        NotificationItems(
            notificationName = "Desconto Relâmpago!",
            notificationComplement = "50% off em café por 30 minutos!",
            notificationDate = "30/11",
            notificationImage = R.drawable.c2
        )
    )


}