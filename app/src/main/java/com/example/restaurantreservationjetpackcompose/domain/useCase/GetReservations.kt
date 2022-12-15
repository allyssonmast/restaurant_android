package com.example.restaurantreservationjetpackcompose.domain.useCase

import com.example.restaurantreservationjetpackcompose.domain.entities.Reservation
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import com.example.restaurantreservationjetpackcompose.common.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetReservations @Inject constructor(private val repository: IRestaurantRepository) {
    operator fun invoke():Flow<Resource<List<Reservation>>>{
        return repository.getReservations()
    }
}