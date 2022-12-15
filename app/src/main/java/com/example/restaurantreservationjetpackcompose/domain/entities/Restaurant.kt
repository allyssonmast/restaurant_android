package com.example.restaurantreservationjetpackcompose.domain.entities

data class Restaurant (
    var customers: List<Customer>,
    var tables: List<Table>,
    var reservation: List<Reservation>
)