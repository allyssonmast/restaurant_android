package com.example.restaurantreservationjetpackcompose.data.remote.dto

import com.example.restaurantreservationjetpackcompose.domain.entities.Reservation

data class ReservationDto(
    val userId: Int,
    val tableId: Int,
    val id: Int,
){
    fun toReservation(): Reservation{
        return Reservation(
            userId=userId,
            tableId=tableId,
            id=id
        )
    }
}
