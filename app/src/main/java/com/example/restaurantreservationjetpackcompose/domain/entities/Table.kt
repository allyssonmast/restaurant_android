package com.example.restaurantreservationjetpackcompose.domain.entities

data class Table(
    val id: Int,
    val shape: String,
    val reserveBy: String?
)
