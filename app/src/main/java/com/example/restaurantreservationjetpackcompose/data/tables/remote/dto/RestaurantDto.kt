package com.example.restaurantreservationjetpackcompose.data.tables.remote.dto

import com.example.restaurantreservationjetpackcompose.domain.entities.Restaurant

data class RestaurantDto (
    var tables: List<TableDto>,
    var customers: List<CustomerDto>,
    var reservations: List<ReservationDto>
){
    fun toRestaurant():Restaurant{
        return Restaurant(
            tables = tables.map { it.toTables() },
            reservation = reservations.map { it.toReservation() },
            customers = customers.map { it.toCustomers() }
        )
    }
}