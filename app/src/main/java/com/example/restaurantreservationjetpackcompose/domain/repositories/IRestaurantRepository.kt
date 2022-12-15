package com.example.restaurantreservationjetpackcompose.domain.repositories

import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.example.restaurantreservationjetpackcompose.domain.entities.Reservation
import com.example.restaurantreservationjetpackcompose.domain.entities.Table
import com.example.restaurantreservationjetpackcompose.common.Resource
import kotlinx.coroutines.flow.Flow

interface IRestaurantRepository {
    fun getCustomers(): Flow<Resource<List<Customer>>>
    fun getTables(): Flow<Resource<List<Table>>>
    fun getReservations(): Flow<Resource<List<Reservation>>>
}