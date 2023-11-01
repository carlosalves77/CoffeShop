package com.carlos.coffeshopapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Home") {

        composable(route = "Onboarding") {
            Onboarding(navController)
        }

        composable(route = "Home") {
//            Home(navController)
        }

        composable(route = "DetailScreen") {
            DetailScreen(navController)
        }

        composable(route = "OrderScreen") {
//            OrderScreen(navController)
        }

    }
}