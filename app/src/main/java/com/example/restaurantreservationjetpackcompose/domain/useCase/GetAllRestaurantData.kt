package com.example.restaurantreservationjetpackcompose.domain.useCase

import com.example.restaurantreservationjetpackcompose.common.Resource
import com.example.restaurantreservationjetpackcompose.domain.entities.Restaurant
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllRestaurantData @Inject constructor(
    private val repository: IRestaurantRepository
) {
    operator fun invoke():Flow<Resource<Restaurant>>{
        return repository.getAllRestaurantData()
    }
}