package com.example.restaurantreservationjetpackcompose.presetation.customers

import com.example.restaurantreservationjetpackcompose.domain.entities.Customer

data class CustomersState(
    val isLoging: Boolean=false,
    val customers: List<Customer> = emptyList(),
    val error: String = ""
)
