package com.example.restaurantreservationjetpackcompose.data.tables.remote.dto

import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.google.gson.annotations.SerializedName

data class CustomerDto(
    @SerializedName("first_name")val firstName: String,
    @SerializedName("last_name")val lastName: String,
    @SerializedName("image_url")val imageUrl: String,
    val id: Int
){
    fun toCustomers():Customer{
        return Customer(
            firstName=firstName,
            lastName=lastName,
            imageUrl=imageUrl,
            id=id
        )
    }
}
