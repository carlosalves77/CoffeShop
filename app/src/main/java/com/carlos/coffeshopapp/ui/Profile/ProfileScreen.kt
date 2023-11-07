package com.carlos.coffeshopapp.ui.Profile

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Place
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.ui.theme.BackGroundColor

@Composable
fun ProfileScreen(navController: NavController) {

    val modifier = Modifier

    BackHandler {
        navController.popBackStack()
    }

    data class OptionList(
        val firstName: String,
        val secondName: String? = null,
        val icon: ImageVector,
    )


    val listOfOption = listOf(
        OptionList(
            firstName = "Endereços",
            secondName = "Meus endereços de entrega",
            icon = Icons.Outlined.Place
        ),
        OptionList(
            firstName = "Assinaturas",
            secondName = "Minhas assinaturas",
            icon = Icons.Outlined.ThumbUp
        ),
        OptionList(
            firstName = "Meus Dados",
            secondName = "Minhas informações da conta",
            icon = Icons.Outlined.AccountBox
        ),
        OptionList(
            firstName = "Pagamentos",
            secondName = "Meus saldos e cartões",
            icon = Icons.Outlined.DateRange
        ),
        OptionList(
            firstName = "Cupons",
            secondName = "Meus cupons de desconto",
            icon = Icons.Outlined.FavoriteBorder
        )
        ,
        OptionList(
            firstName = "Ajuda",
            icon = Icons.Outlined.Info
        ),
        OptionList(
            firstName = "Configurações",
            icon = Icons.Outlined.Settings
        ),
        OptionList(
            firstName = "Segurança",
            icon = Icons.Outlined.Lock
        )


    )

    Column(
        modifier
            .fillMaxSize()
            .background(BackGroundColor)
            .verticalScroll(rememberScrollState()),
    ) {
        Spacer(modifier.height(40.dp))
        Row(
            modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(horizontal = 30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profilepicture),
                contentDescription = "profile",
                modifier
                    .size(55.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop

            )

            Text(
                text = "Carlos Alves",
                modifier.padding(start = 20.dp),
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.sora_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF303336),

                )
        }
        Spacer(
            modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(color = Color(0xFFF4F4F4))
        )
        Spacer(
            modifier
                .height(20.dp)
        )
        listOfOption.forEach { item ->
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(bottom = if(item.firstName == "Segurança") 50.dp else 0.dp)
                    .height(100.dp)
                    .border(width = 1.dp, color = Color(0xFFEAEAEA))
                    .padding(start = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    item.icon,
                    contentDescription = "Place",
                    modifier.size(34.dp),
                    tint = Color.Black
                )
                Column(modifier.padding(start = 15.dp)) {
                    Text(
                        text = item.firstName,
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.sora_medium)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF2F2D2C),
                    )
                    Text(
                        text = item.secondName ?: "",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.sora_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF9B9B9B),
                    )
                }
                Row(
                    modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Icon(
                        Icons.Default.KeyboardArrowRight,
                        contentDescription = "ArrowRight",
                        modifier
                            .size(38.dp)
                            .padding(end = 10.dp),
                        tint = Color(0xFF9B9B9B)
                    )
                }

            }
        }

    }
}