package com.carlos.coffeshopapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.carlos.coffeshopapp.ui.Navigation.NavGraph


class MainActivity : ComponentActivity() {
 
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)



        setContent {
            val navController = rememberNavController()
            NavGraph(navController)
//            BottomNavigation(navController)
//
//               NavGraph(navController)
//           CoffeShopAppTheme {
//
//           }
//            Home()


//                DeliveryScreen()
//                OrderScreen()
            // Home()

//                OrderScreen()
//            DetailScreen()

        }
    }
}

