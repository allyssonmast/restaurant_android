package com.example.restaurantreservationjetpackcompose.domain.useCase

import com.example.restaurantreservationjetpackcompose.domain.entities.Table
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import com.example.restaurantreservationjetpackcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTables @Inject constructor(
    private val repository: IRestaurantRepository
){
    operator fun invoke(): Flow<Resource<List<Table>>> {
        return repository.getTables()
    }
}