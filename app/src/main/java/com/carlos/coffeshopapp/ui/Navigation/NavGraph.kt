package com.carlos.coffeshopapp.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.carlos.coffeshopapp.ui.BagScreen.BagScreen
import com.carlos.coffeshopapp.ui.BottomNavigation.BottomNavigation
import com.carlos.coffeshopapp.ui.Delivery.DeliveryScreen
import com.carlos.coffeshopapp.ui.DetailScreen.DetailScreen
import com.carlos.coffeshopapp.ui.FavoriteScreen.FavoriteScreen
import com.carlos.coffeshopapp.ui.HomeScreen.Home
import com.carlos.coffeshopapp.ui.NotificationScreen.NotificationScreen
import com.carlos.coffeshopapp.ui.Onboarding.Onboarding
import com.carlos.coffeshopapp.ui.OrderScreen.OrderScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "Onboarding") {

        composable(route = "Onboarding") {
            Onboarding(navController)
        }

        composable(route = "BottomNavigation") {
            BottomNavigation(navController)
        }

        composable(route = "Home") {
            Home(navController)
        }

        composable(route = "DetailScreen/{coffeeName}/{coffeeComplement}/{coffeeImage}/{coffeePrice}",
            arguments = listOf(
                navArgument(name = "coffeeName") {
                    type = NavType.StringType
                },
                navArgument(name = "coffeeComplement") {
                    type = NavType.StringType
                },
                navArgument(name = "coffeeImage") {
                    type = NavType.IntType
                },
                navArgument(name = "coffeePrice") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            DetailScreen(
                navController,
                backStackEntry.arguments?.getString("coffeeName"),
                backStackEntry.arguments?.getString("coffeeComplement"),
                backStackEntry.arguments?.getInt("coffeeImage"),
                backStackEntry.arguments?.getString("coffeePrice")
            )
        }

        composable(route = "OrderScreen") {
            OrderScreen(navController)
        }

        composable(route = "DeliveryScreen") {
            DeliveryScreen(navController)
        }

        composable(route = "BagScreen") {
            BagScreen(navController)
        }

        composable(route = "FavoriteScreen") {
            FavoriteScreen(navController)
        }

        composable(route = "NotificationScreen") {
            NotificationScreen(navController)
        }

    }
}