package com.example.restaurantreservationjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaurantreservationjetpackcompose.common.Screen
import com.example.restaurantreservationjetpackcompose.presetation.tables.ui.TablesSreen
import com.example.restaurantreservationjetpackcompose.common.theme.RestaurantReservationJetpackComposeTheme
import com.example.restaurantreservationjetpackcompose.presetation.customers.ui.CustomersScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantReservationJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.TablesScreen.route
                    ){
                        composable(
                            route = Screen.TablesScreen.route
                        ){
                            TablesSreen(navController = navController)
                        }
                        composable(
                            route = Screen.CustomersScreen.route+"/{tableId}"
                        ){
                            CustomersScreen(navController)
                        }
                    }
                }
            }
        }
    }
}