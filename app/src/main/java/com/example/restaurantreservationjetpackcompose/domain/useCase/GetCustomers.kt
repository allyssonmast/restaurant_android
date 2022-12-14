package com.example.restaurantreservationjetpackcompose.domain.useCase

import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import com.example.restaurantreservationjetpackcompose.util.Resource
import kotlinx.coroutines.flow.Flow

class GetCustomers(
    private val repository: IRestaurantRepository
) {
    operator fun invoke(): Flow<Resource<List<Customer>>> {
        return repository.getCustomers()
    }
}