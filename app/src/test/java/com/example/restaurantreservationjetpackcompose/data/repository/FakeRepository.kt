package com.example.restaurantreservationjetpackcompose.data.repository

import com.example.restaurantreservationjetpackcompose.common.Resource
import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.example.restaurantreservationjetpackcompose.domain.entities.Reservation
import com.example.restaurantreservationjetpackcompose.domain.entities.Restaurant
import com.example.restaurantreservationjetpackcompose.domain.entities.Table
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRepository:IRestaurantRepository {

    private val list = mutableListOf<Table>()
    private val listCustomer = mutableListOf<Customer>()
    private val listReservation = mutableListOf<Reservation>()
    override fun getCustomers(): Flow<Resource<List<Customer>>> {
        return flow { listCustomer }
    }

    override fun getTables(): Flow<Resource<List<Table>>> {
        return flow { list }
    }

    override fun getReservations(): Flow<Resource<List<Reservation>>> {
        return flow { listReservation }
    }

    override fun getAllRestaurantData(): Flow<Resource<Restaurant>> {
        TODO("Not yet implemented")
    }
}