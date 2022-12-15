package com.example.restaurantreservationjetpackcompose.data.tables.remote.dto

import com.example.restaurantreservationjetpackcompose.domain.entities.Reservation
import com.google.gson.annotations.SerializedName

data class ReservationDto(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("table_id") val tableId: Int,
    @SerializedName("id") val id: Int,
){
    fun toReservation(): Reservation{
        return Reservation(
            userId=userId,
            tableId=tableId,
            id=id
        )
    }
}
