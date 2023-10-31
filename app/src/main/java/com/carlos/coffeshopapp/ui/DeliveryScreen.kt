package com.carlos.coffeshopapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.carlos.coffeshopapp.R
import com.carlos.coffeshopapp.ui.theme.IconColor
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@OptIn(ExperimentalMaterial3Api::class)
@Preview(device = "id:pixel_4")
@Composable
fun DeliveryScreen() {
    val singapore = LatLng(1.35, 103.87)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(singapore, 10f)
    }

    val modifier = Modifier

    ConstraintLayout(modifier.fillMaxSize()) {
        val (backButton, findLocation, bottomSheet) = createRefs()

        Row(
            modifier
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
                .padding(start = 30.dp, top = 60.dp)
                .zIndex(1f)
                .shadow(
                    elevation = 24.dp,
                    spotColor = Color(0x40E4E4E4),
                    ambientColor = Color(0x40E4E4E4)
                )
                .width(44.dp)
                .height(44.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 14.dp)),
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "BackButton",
                modifier
                    .size(38.dp)
                    .clickable(indication = null, interactionSource = MutableInteractionSource()) {


                    },
                tint = IconColor,
            )
        }
        Row(
            modifier
                .constrainAs(findLocation) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
                .padding(end = 30.dp, top = 60.dp)
                .zIndex(1f)
                .shadow(
                    elevation = 24.dp,
                    spotColor = Color(0x40E4E4E4),
                    ambientColor = Color(0x40E4E4E4)
                )
                .width(44.dp)
                .height(44.dp)
                .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 14.dp)),
            horizontalArrangement = Arrangement.spacedBy(0.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.gps),
                contentDescription = "Coffee Icon",
                modifier
                    .size(24.dp)
                    .fillMaxSize()

            )

        }

        BottomSheetScaffold(sheetContent = {
        },
       modifier.fillMaxWidth()
           .height(322.dp),
            sheetContainerColor = Color.Black,
        ) {

        }

//        GoogleMap(
//            modifier = Modifier.fillMaxSize(),
//            cameraPositionState = cameraPositionState
//        ) {
//            Marker(
//                state = MarkerState(position = singapore),
//                title = "Singapore",
//                snippet = "Marker in Singapore"
//            )
//        }
    }


}