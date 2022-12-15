package com.example.restaurantreservationjetpackcompose.presetation.tables

import com.example.restaurantreservationjetpackcompose.domain.entities.Table

data class TablesState(
    val isLoging: Boolean=false,
    val tables: List<Table> = emptyList(),
    val error: String = ""
)
