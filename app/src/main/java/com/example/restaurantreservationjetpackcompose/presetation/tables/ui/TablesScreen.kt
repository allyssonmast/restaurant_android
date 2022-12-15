package com.example.restaurantreservationjetpackcompose.presetation.tables.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.restaurantreservationjetpackcompose.presetation.tables.TablesViewModel

@Composable
fun TablesSreen(
    navController: NavController,
    viewModel: TablesViewModel = hiltViewModel()
){
    val state= viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(modifier = Modifier.fillMaxSize()){


            items(state.tables){ table ->
                val customer= viewModel.getCustomer(table)
                TableItem(
                    table = table,
                    customer = customer,
                    onItemClick = {

                })
            }
        }

        if(state.error.isBlank())
            Text(
                text = state.error,
                textAlign = TextAlign.Center
            )

        if(state.isLoging)
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))


    }
}