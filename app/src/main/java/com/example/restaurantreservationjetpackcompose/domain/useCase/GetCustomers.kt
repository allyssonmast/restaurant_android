package com.example.restaurantreservationjetpackcompose.domain.useCase

import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import com.example.restaurantreservationjetpackcompose.common.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCustomers @Inject constructor(
    private val repository: IRestaurantRepository
) {
    operator fun invoke(): Flow<Resource<List<Customer>>> {
        return repository.getCustomers()
    }
}