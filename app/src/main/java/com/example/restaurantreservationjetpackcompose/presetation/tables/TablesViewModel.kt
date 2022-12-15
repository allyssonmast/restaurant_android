package com.example.restaurantreservationjetpackcompose.presetation.tables

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantreservationjetpackcompose.common.Resource
import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.example.restaurantreservationjetpackcompose.domain.entities.Restaurant
import com.example.restaurantreservationjetpackcompose.domain.entities.Table
import com.example.restaurantreservationjetpackcompose.domain.useCase.GetAllRestaurantData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TablesViewModel @Inject constructor(
    private val getTablesUseCase: GetAllRestaurantData
):ViewModel(){
    private val _state = mutableStateOf<TablesState>(TablesState())
    val state: State<TablesState> = _state

    init {
        getTables()
    }

    private fun getTables(){
        getTablesUseCase().onEach { resource ->
            when(resource){
                is Resource.Success ->{
                    _state.value= TablesState(
                        restaurant =
                        resource.data?: Restaurant(
                            emptyList(), emptyList(), emptyList()
                    ))
                }
                is Resource.Error ->{
                    _state.value =TablesState(error = resource.message?:"An error occured")
                }
                is Resource.Loading ->{
                    _state.value = TablesState(isLoging = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getCustomer(table: Table): Customer? {

        val reservation =
            state.value.restaurant.reservation.firstOrNull { reservation -> reservation.tableId==table.id }

        val customer:Customer? = if(reservation!=null){
            _state.value.restaurant.customers.firstOrNull { custome -> custome.id== reservation.userId }
        }else{
            null
        }

        return  customer
    }

}