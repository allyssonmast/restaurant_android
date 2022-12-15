package com.example.restaurantreservationjetpackcompose.presetation.tables

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restaurantreservationjetpackcompose.domain.useCase.GetTables
import com.example.restaurantreservationjetpackcompose.common.Resource
import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.example.restaurantreservationjetpackcompose.domain.entities.Table
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TablesViewModel @Inject constructor(
    private val getTablesUseCase: GetTables
):ViewModel(){
    private val _stateCustomers = mutableStateOf<TablesState>(TablesState())
    private val _stateReservations = mutableStateOf<TablesState>(TablesState())
    private val _state = mutableStateOf<TablesState>(TablesState())
    val state: State<TablesState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow=_eventFlow.asSharedFlow()


    init {
        getTables()
    }

    private fun getTables(){
        getTablesUseCase().onEach { resource ->
            when(resource){
                is Resource.Success ->{
                    _state.value= TablesState(tables = resource.data?: emptyList())
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

    fun getCustomer(table: Table): Customer {

        return Customer(firstName = "Allysson", lastName = "Mastrangelo", imageUrl = "", id = 1);
    }

    sealed class UIEvent{
        data class ShowSnackBar(val message: String):UIEvent()
    }
}