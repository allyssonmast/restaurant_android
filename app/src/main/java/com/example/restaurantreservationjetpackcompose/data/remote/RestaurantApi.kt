package com.example.restaurantreservationjetpackcompose.data.remote

import com.example.restaurantreservationjetpackcompose.common.Constants
import com.example.restaurantreservationjetpackcompose.data.remote.dto.CustomerDto
import com.example.restaurantreservationjetpackcompose.data.remote.dto.ReservationDto
import com.example.restaurantreservationjetpackcompose.data.remote.dto.TableDto
import retrofit2.http.GET

interface RestaurantApi {

    @GET(Constants.CUSTOMER)
    suspend fun getCustomers(): List<CustomerDto>

    @GET(Constants.RESERVATION)
    suspend fun getReservations(): List<ReservationDto>

    @GET(Constants.TABLE)
    suspend fun getTables(): List<TableDto>

}