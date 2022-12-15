package com.example.restaurantreservationjetpackcompose.data.repository

import com.example.restaurantreservationjetpackcompose.data.remote.RestaurantApi
import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.example.restaurantreservationjetpackcompose.domain.entities.Reservation
import com.example.restaurantreservationjetpackcompose.domain.entities.Table
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import com.example.restaurantreservationjetpackcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class RepositoryRestaurantImp @Inject constructor(
    private val api: RestaurantApi
): IRestaurantRepository {
    override  fun getCustomers(): Flow<Resource<List<Customer>>> = flow {
        emit(Resource.Loading())
        try {
            val result = api.getCustomers()
            emit(Resource.Success(result.map { it.toCustomers() }))
        }catch (e: HttpException){
            emit(Resource.Error(
                "Ops, somethings went wrong",
                data = null
            ))
        }catch (e: IOException){
            emit(Resource.Error("Check your internet"))
        }
    }

    override fun getTables(): Flow<Resource<List<Table>>> = flow {
        emit(Resource.Loading())
        try {
            val result = api.getTables()
            emit(Resource.Success(result.map { it.toTables() }))
        }catch (e: HttpException){
            emit(Resource.Error(
                "Ops, somethings went wrong",
                data = null
            ))
        }catch (e: IOException){
            emit(Resource.Error("Check your internet"))
        }
    }

    override fun getReservations(): Flow<Resource<List<Reservation>>>  = flow{
        emit(Resource.Loading())
        try {
            val result = api.getReservations()
            emit(Resource.Success(result.map { it.toReservation() }))
        }catch (e: HttpException){
            emit(Resource.Error(
                "Ops, somethings went wrong",
                data = null
            ))
        }catch (e: IOException){
            emit(Resource.Error("Check your internet"))
        }
    }
}