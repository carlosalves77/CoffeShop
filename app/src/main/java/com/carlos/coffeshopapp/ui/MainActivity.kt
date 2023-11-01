package com.carlos.coffeshopapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.core.view.WindowCompat
import com.carlos.coffeshopapp.ui.Delivery.DeliveryScreen


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)



        setContent {
            Scaffold {
                DeliveryScreen()
            }
            // Home()

//                OrderScreen()
//            DetailScreen()

//            NavGraph()
        }
    }
}

