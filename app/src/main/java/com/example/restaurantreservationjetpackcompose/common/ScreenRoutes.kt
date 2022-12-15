package com.example.restaurantreservationjetpackcompose.common

sealed class Screen(val route: String){
    object TablesScreen: Screen("tables_screen")
    object CustomersScreen: Screen("customers_screen")
}
