package com.carlos.coffeshopapp.ui.OrderScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.ui.theme.BackGroundColor
import com.carlos.coffeshopapp.ui.theme.IconColor



@Composable
fun OrderScreen(navController: NavController) {
    val modifier = Modifier

    val isButtonEnabled = remember { mutableStateOf(false) }
    val value = remember { mutableIntStateOf(1) }
    if (value.intValue < 1) value.intValue = 1


    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(BackGroundColor)
    ) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(top = 55.dp, start = 24.dp, end = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ConstraintLayout(modifier.fillMaxSize()) {
                val (icon, text) = createRefs()
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = "BackButton",
                    modifier
                        .size(38.dp)
                        .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                            navController.popBackStack()
                        }
                        .constrainAs(icon) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        },
                    tint = IconColor
                )
                Text(
                    text = "Ordem",
                    modifier.constrainAs(text) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    },
                    fontFamily = FontFamily(Font(R.font.sora_bold, FontWeight(800))),
                    color = IconColor,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier.padding(top = 25.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .height(48.dp)
                .background(color = Color(0xFFF2F2F2), shape = RoundedCornerShape(size = 14.dp))
                .padding(start = 4.dp, top = 4.dp, end = 4.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                Modifier
                    .width(153.5.dp)
                    .height(40.dp)
                    .clickable {
                        isButtonEnabled.value = !isButtonEnabled.value
                    }
                    .background(
                        color = if (isButtonEnabled.value) Color.Transparent else Color(0xFFC67C4E),
                        shape = RoundedCornerShape(size = 10.dp)
                    ),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Entregar",
                    fontSize = 16.sp,
                    fontFamily = if (isButtonEnabled.value) FontFamily(Font(R.font.sora_medium)) else FontFamily(
                        Font(R.font.sora_bold)
                    ),
                    fontWeight = FontWeight(600),
                    color = if (isButtonEnabled.value) Color(0xFF2F2D2C) else Color.White,

                    )

            }
            Row(
                Modifier
                    .width(153.5.dp)
                    .height(40.dp)
                    .clickable {
                        isButtonEnabled.value = !isButtonEnabled.value
                    }
                    .background(
                        color = if (isButtonEnabled.value) Color(0xFFC67C4E) else Color.Transparent,
                        shape = RoundedCornerShape(size = 10.dp)
                    ),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Pegar",
                    fontSize = 16.sp,
                    fontFamily = if (isButtonEnabled.value) FontFamily(Font(R.font.sora_bold)) else FontFamily(
                        Font(R.font.sora_medium)
                    ),
                    fontWeight = FontWeight(600),
                    color = if (isButtonEnabled.value) Color.White else Color(0xFF2F2D2C),
                )

            }

        }
        Spacer(modifier.padding(top = 28.dp))
        Text(
            text = "Endereço de entrega",
            modifier.padding(start = 30.dp),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.sora_bold)),
            fontWeight = FontWeight(600),
            color = Color(0xFF2F2D2C),
        )
        Spacer(modifier.padding(top = 16.dp))
        Text(
            text = "Jl. Kpg Sutoyo",
            modifier.padding(start = 30.dp),
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.sora_bold)),
            fontWeight = FontWeight(600),
            color = Color(0xFF303336),
        )
        Text(
            text = "Kpg. Sutoyo No. 620, Bilzen, Tanjungbalai.",
            modifier.padding(start = 30.dp),
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.sora_regular)),
            fontWeight = FontWeight(400),
            color = Color(0xFF808080),
        )
        Spacer(modifier.padding(top = 16.dp))
        Row(
            modifier.padding(start = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDEDEDE),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .wrapContentSize()
                    .height(27.dp)
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(size = 16.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.editsquare),
                    contentDescription = null,
                    modifier
                        .padding(start = 12.dp)
                        .size(14.dp)
                )
                Text(
                    text = "Editar endereço",
                    modifier.padding(start = 5.dp, end = 12.dp),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sora_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF303336),

                    )

            }
            Row(
                modifier
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDEDEDE),
                        shape = RoundedCornerShape(size = 16.dp)
                    )
                    .wrapContentSize()
                    .height(27.dp)
                    .background(
                        color = Color(0xFFFFFFFF),
                        shape = RoundedCornerShape(size = 16.dp)
                    ),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.document),
                    contentDescription = null,
                    modifier
                        .padding(start = 12.dp)
                        .size(14.dp)
                )
                Text(
                    text = "Adicionar nota",
                    modifier.padding(start = 5.dp, end = 12.dp),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sora_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF303336),

                    )

            }
        }
        Spacer(modifier.padding(top = 20.dp))
        Row(
            modifier
                .padding(0.dp)
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .height(1.dp)
                .background(color = Color(0xFFEAEAEA))
        ) {

        }
        Spacer(modifier.padding(top = 20.dp))
        Row(
            modifier
                .fillMaxWidth()
                .width(315.dp)
                .height(54.dp)
                .padding(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Row() {
                Image(
                    painter = painterResource(id = R.drawable.detailcoffeimage),
                    contentDescription = "image description",
                    modifier
                        .width(54.dp)
                        .height(54.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop,
                )
                Column(
                    modifier
                        .padding(start = 12.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Cappucino",

                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.sora_bold)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF2F2D2C)

                    )
                    Text(
                        text = "Com Chocolate",

                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.sora_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF9B9B9B),


                        )

                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFEAEAEA),
                            shape = RoundedCornerShape(size = 20.dp)
                        )
                        .width(28.dp)
                        .height(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) {
                            value.intValue--
                        }
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 20.dp)
                        )

                ) {
                    Text(
                        text = "-",
                        modifier.fillMaxSize(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }

                Text(
                    text = "${value.intValue}",
                    modifier.padding(start = 12.dp, end = 12.dp),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sora_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2F2D2C),
                )


                Box(
                    modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFEAEAEA),
                            shape = RoundedCornerShape(size = 20.dp)
                        )
                        .width(28.dp)
                        .clickable(
                            indication = null,
                            interactionSource = MutableInteractionSource()
                        ) {
                            value.intValue++
                        }
                        .height(28.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 20.dp)
                        )

                ) {
                    Text(
                        text = "+",
                        modifier.fillMaxSize(),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }


            }
        }
        Spacer(modifier.padding(top = 20.dp))
        Row(
            modifier
                .width(375.dp)
                .height(4.dp)
                .background(color = Color(0xFFF4F4F4))
        ) {

        }
        Spacer(modifier.padding(top = 20.dp))
        Row(
            modifier
                .padding(start = 30.dp, end = 30.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFEAEAEA),
                    shape = RoundedCornerShape(size = 14.dp)
                )
                .fillMaxWidth()
                .height(56.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 14.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier.padding(start = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.discount),
                    contentDescription = "image description",
                    modifier
                        .width(24.dp)
                        .height(24.dp)
                )
                Text(
                    text = "1 Desconto aplicado",
                    modifier.padding(start = 12.dp),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sora_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2F2D2C)
                )

            }
            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "BackButton",
                modifier
                    .padding(end = 18.dp)
                    .size(26.dp)
                    .clickable(indication = null, interactionSource = MutableInteractionSource()) {


                    },
                tint = IconColor,
            )

        }
        Spacer(modifier.padding(top = 20.dp))
        Text(
            text = "Resumo do pagamento",
            modifier.padding(start = 30.dp),
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.sora_bold)),
            fontWeight = FontWeight(600),
            color = Color(0xFF2F2D2C),
        )
        Spacer(modifier.padding(top = 16.dp))
        Row(
            modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Preço",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sora_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF2F2D2C),

                )
            Text(
                text = "$ 4.53",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sora_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF2F2D2C),

                textAlign = TextAlign.Right,

                )
        }

        Spacer(modifier.padding(top = 16.dp))

        Row(
            modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Taxa de entrega",

                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sora_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF2F2D2C),

                )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "$ 2.0",
                    modifier.padding(end = 5.dp),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sora_medium)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF2F2D2C),
                    textAlign = TextAlign.Right,
                    textDecoration = TextDecoration.LineThrough,

                    )
                Text(
                    text = "$ 1.0",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.sora_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2F2D2C),
                    textAlign = TextAlign.Right,
                )
            }
        }

        Spacer(modifier.padding(top = 16.dp))

        Row(
            modifier
                .padding(0.dp)
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
                .height(1.dp)
                .background(color = Color(0xFFEAEAEA))
        ) {
        }

        Spacer(modifier.padding(top = 16.dp))

        Row(
            modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Pagamento total",

                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sora_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF2F2D2C),

                )
            Text(
                text = "$ 5.53",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sora_bold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF2F2D2C),

                textAlign = TextAlign.Right,

                )
        }
        Column(
            modifier
                .shadow(
                    elevation = 24.dp,
                    spotColor = Color(0x40E4E4E4),
                    ambientColor = Color(0x40E4E4E4)
                )
                .fillMaxWidth()
                .height(200.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 24.dp))
        ) {
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(start = 29.dp, top = 16.dp, end = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.moneys),
                        contentDescription = "image description",
                        modifier
                            .width(24.dp)
                            .height(24.dp)
                    )
                    Row(
                        modifier
                            .padding(start = 12.dp)
                            .wrapContentSize()
                            .height(24.dp)
                            .background(
                                color = Color(0xFFF6F6F6),
                                shape = RoundedCornerShape(size = 20.dp)
                            )
                            .padding(end = 14.dp),
                        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier
                                .wrapContentSize()
                                .fillMaxHeight()
                                .background(
                                    color = Color(0xFFC67C4E),
                                    shape = RoundedCornerShape(size = 20.dp)
                                )
                                .padding(start = 8.dp, end = 8.dp)
                        ) {
                            Text(
                                text = "Dinheiro",
                                modifier.fillMaxHeight(),
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                lineHeight = 14.sp,
                                fontFamily = FontFamily(Font(R.font.sora_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFFFFFFFF),

                                )
                        }
                        Box(
                            modifier
                                .wrapContentSize()
                                .fillMaxHeight()
                                .background(
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(size = 20.dp)
                                )

                        ) {
                            Text(
                                text = "$ 5.53",
                                modifier.fillMaxHeight(),
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center,
                                lineHeight = 14.sp,
                                fontFamily = FontFamily(Font(R.font.sora_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF2F2D2C),

                                )
                        }
                    }


                }
                Image(
                    painter = painterResource(id = R.drawable.dots),
                    contentDescription = "image description",
                    modifier
                        .width(24.dp)
                        .height(24.dp)
                )

            }

            Spacer(modifier.padding(top = 16.dp))

            Row(
                modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp)
                    .height(62.dp)
                    .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                        navController.navigate("DeliveryScreen")
                    }
                    .background(
                        color = Color(0xFFC67C4E),
                        shape = RoundedCornerShape(size = 16.dp)
                    ),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Finalizar",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sora_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFFFFFFFF),
                )
            }


        }


    }

}