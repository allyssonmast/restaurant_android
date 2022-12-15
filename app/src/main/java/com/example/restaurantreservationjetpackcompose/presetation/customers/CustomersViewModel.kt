package com.example.restaurantreservationjetpackcompose.presetation.customers

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantreservationjetpackcompose.common.Resource
import com.example.restaurantreservationjetpackcompose.domain.useCase.GetCustomers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val getCustomers: GetCustomers
):ViewModel() {

    private val _state = mutableStateOf<CustomersState>(CustomersState())
    val state: State<CustomersState> = _state

    init {
        getTables()
    }

    private fun getTables(){
        getCustomers().onEach { resource ->
            when(resource){
                is Resource.Success ->{
                    _state.value= CustomersState(customers = resource.data?: emptyList())
                }
                is Resource.Error ->{
                    _state.value = CustomersState(error = resource.message?:"An error occured")
                }
                is Resource.Loading ->{
                    _state.value = CustomersState(isLoging = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}