package com.example.restaurantreservationjetpackcompose.data.remote.dto

import com.example.restaurantreservationjetpackcompose.domain.entities.Table

data class TableDto (
    val id: Int,
    val shape: String,
    val reserveBy: String?
){
    fun toTables():Table{
        return Table(
            id=id,
            shape=shape,
            reserveBy=reserveBy
        )
    }
}