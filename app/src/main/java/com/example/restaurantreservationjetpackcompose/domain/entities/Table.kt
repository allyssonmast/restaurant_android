package com.example.restaurantreservationjetpackcompose.domain.entities

import androidx.annotation.Nullable

data class Table(
    val id: Int,
    val shape: String,
    val reserveBy: String?
)
