package com.example.restaurantreservationjetpackcompose.data.remote.dto

import com.example.restaurantreservationjetpackcompose.domain.entities.Customer

data class CustomerDto(
    val firstName: String,val lastName: String,val imageUrl: String,val id: Int

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
