package com.example.restaurantreservationjetpackcompose.data.remote

import com.example.restaurantreservationjetpackcompose.common.Constants
import com.example.restaurantreservationjetpackcompose.data.remote.dto.CustomerDto
import com.example.restaurantreservationjetpackcompose.data.remote.dto.ReservationDto
import com.example.restaurantreservationjetpackcompose.data.remote.dto.TableDto
import retrofit2.http.GET

interface RestaurantApi {

    @GET(Constants.CUSTOMER)
    fun getCustomers(): List<CustomerDto>

    @GET(Constants.RESERVATION)
    fun getReservations(): List<ReservationDto>

    @GET(Constants.TABLE)
    fun getTables(): List<TableDto>

}