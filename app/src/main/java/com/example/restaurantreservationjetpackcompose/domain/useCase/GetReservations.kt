package com.example.restaurantreservationjetpackcompose.domain.useCase

import com.example.restaurantreservationjetpackcompose.domain.entities.Reservation
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import com.example.restaurantreservationjetpackcompose.util.Resource
import kotlinx.coroutines.flow.Flow

class GetReservations(private val repository: IRestaurantRepository) {
    operator fun invoke():Flow<Resource<List<Reservation>>>{
        return repository.getReservations()
    }
}