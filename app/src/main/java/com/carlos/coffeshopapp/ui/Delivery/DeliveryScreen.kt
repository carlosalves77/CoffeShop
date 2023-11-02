package com.carlos.coffeshopapp.ui.Delivery

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.ui.Delivery.components.MapMarker
import com.carlos.coffeshopapp.ui.theme.IconColor
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeliveryScreen(navController: NavController) {
    val modifier = Modifier
    val unibra = LatLng(-8.053865337579085, -34.893402490353786)
    val deliveryguy = LatLng(-8.056640376972373, -34.892880078432974)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(unibra, 18f)
    }
    val scaffoldState = rememberBottomSheetScaffoldState()


    ConstraintLayout(modifier.fillMaxSize()) {
        val (backButton, locationButton) = createRefs()

        Row(
            modifier
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(top = 60.dp, start = 30.dp)
                .zIndex(1f)
                .shadow(
                    elevation = 24.dp,
                    spotColor = Color(0x40E4E4E4),
                    ambientColor = Color(0x40E4E4E4)
                )
                .width(44.dp)
                .height(44.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 14.dp)
                )
                .clickable(indication = null, interactionSource = MutableInteractionSource()) {
                    navController.navigate("BottomNavigation")
                },
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "BackButton",
                modifier
                    .size(38.dp),
                tint = IconColor,
            )
        }
        Row(
            modifier
                .constrainAs(locationButton) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(top = 60.dp, end = 30.dp)
                .zIndex(1f)
                .shadow(
                    elevation = 24.dp,
                    spotColor = Color(0x40E4E4E4),
                    ambientColor = Color(0x40E4E4E4)
                )
                .width(44.dp)
                .height(44.dp)
                .background(
                    color = Color(0xFFFFFFFF),
                    shape = RoundedCornerShape(size = 14.dp)
                )
                .clickable(indication = null, interactionSource = MutableInteractionSource()) {

                },
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.gps),
                contentDescription = "Location",
                modifier
                    .size(24.dp)
                    .fillMaxSize()
            )

        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {

            MapMarker(
                position = unibra,
                context = LocalContext.current,
                title = "Destinatário",
                iconResourceId = R.drawable.location
            )

            MapMarker(
                position = deliveryguy,
                context = LocalContext.current,
                title = "Entregador",
                iconResourceId = R.drawable.deliveryguymaps
            )

            Polyline(
                points = listOf(
                    LatLng(-8.05648165518229, -34.89295009779546),
                    LatLng(-8.056048431379832, -34.89427374497165),
                    LatLng(-8.054094632608294, -34.893900656155814),
                    LatLng(-8.053931770581892, -34.893807172195814),
                    LatLng(-8.053850925378557, -34.89369002141116),
                    LatLng(-8.053865337579085, -34.893402490353786),
                ), color = Color(0xFFC67C4E)
            )


        }


    }

    BottomSheetScaffold(
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .height(322.dp)
                    .padding(start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "2 minutos para chegada",
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sora_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF303336),
                )
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "Entrega para${" "}",
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.sora_medium)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF808080),
                    )
                    Text(
                        text = "Carlos Alves",
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.sora_bold)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF303336),
                    )
                }

                Spacer(Modifier.height(20.dp))
                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    for (i in 0..3) {
                        Row(
                            modifier
                                .width(71.25.dp)
                                .height(4.dp)
                                .background(
                                    color = if (i == 3) Color(0xFFDFDFDF) else Color(0xFF36C07E),
                                    shape = RoundedCornerShape(size = 20.dp)
                                )
                        ) {
                        }

                    }
                }
                Spacer(Modifier.height(12.dp))
                Column(
                    modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFFEAEAEA),
                            shape = RoundedCornerShape(size = 14.dp)
                        )
                        .fillMaxWidth()
                        .height(90.dp)
                        .background(
                            color = Color(0xFFFFFFFF),
                            shape = RoundedCornerShape(size = 14.dp)
                        )
                        .padding(start = 16.dp, top = 14.dp, end = 16.dp, bottom = 14.dp),
                    verticalArrangement = Arrangement.Center,

                    ) {
                    Row(modifier.fillMaxWidth()) {
                        Row(
                            modifier
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFFDEDEDE),
                                    shape = RoundedCornerShape(size = 12.dp)
                                )
                                .width(62.dp)
                                .height(62.dp)
                                .background(
                                    color = Color(0xFFFFFFFF),
                                    shape = RoundedCornerShape(size = 12.dp)
                                )
                                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(
                                4.dp,
                                Alignment.CenterHorizontally
                            ),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.bike),
                                contentDescription = "Delivery",
                                modifier
                                    .width(32.dp)
                                    .height(32.dp)
                                    .padding(
                                        start = 2.66667.dp,
                                        top = 2.66667.dp,
                                        end = 2.66667.dp,
                                        bottom = 2.66667.dp
                                    )
                            )

                        }
                        Spacer(Modifier.padding(start = 12.dp))
                        Column {
                            Text(
                                text = "Entregando seu pedido",
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.sora_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF303336),

                                )
                            Text(
                                text = "Entregamos suas mercadorias para você no menor tempo possível.",
                                fontSize = 12.sp,
                                lineHeight = 18.48.sp,
                                fontFamily = FontFamily(Font(R.font.sora_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF808080),


                                )
                        }

                    }

                }

                Spacer(Modifier.height(20.dp))

                Row(
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.deliveryman),
                            contentDescription = "image description",
                            modifier
                                .width(54.dp)
                                .height(54.dp),
                            contentScale = ContentScale.FillBounds
                        )
                        Spacer(Modifier.padding(start = 12.dp))
                        Column(
                            modifier
                                .height(46.dp),
                            verticalArrangement = Arrangement.SpaceBetween,
                            horizontalAlignment = Alignment.Start,
                        ) {
                            Text(
                                text = "Carlos Alves",

                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.sora_bold)),
                                fontWeight = FontWeight(600),
                                color = Color(0xFF303336),

                                )
                            Text(
                                text = "Correio Pessoal",
                                fontSize = 12.sp,
                                fontFamily = FontFamily(Font(R.font.sora_medium)),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF808080),


                                )
                        }
                    }
                    Row(
                        modifier
                            .border(
                                width = 1.dp,
                                color = Color(0xFFDEDEDE),
                                shape = RoundedCornerShape(size = 14.dp)
                            )
                            .width(54.dp)
                            .height(54.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.telpon),
                            contentDescription = "telpon",
                            modifier
                                .width(24.dp)
                                .height(24.dp),
                            contentScale = ContentScale.FillBounds
                        )

                    }


                }

            }
        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = 100.dp,
        sheetContainerColor = Color(0xFFFFFFFF)
    ) {

    }


}