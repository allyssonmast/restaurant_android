package com.example.restaurantreservationjetpackcompose.presetation.tables.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.restaurantreservationjetpackcompose.common.Screen
import com.example.restaurantreservationjetpackcompose.presetation.tables.TablesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TablesSreen(
    navController: NavController,
    viewModel: TablesViewModel = hiltViewModel()
){
    val state= viewModel.state.value

    Scaffold (
        topBar = {
            TopAppBar(
                colors =  TopAppBarDefaults
                    .mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                title = {
                    Text(text = "Top App Bar")
                },
            )
        }
            ){ paddingValues ->
        LazyColumn(modifier =  Modifier.padding(paddingValues),){


            items(state.restaurant.tables){ table ->
                val customer= viewModel.getCustomer(table)
                TableItem(
                    table = table,
                    customer = customer,
                    onItemClick = {
                        navController.navigate(Screen.CustomersScreen.route+"/${table.id}")
                })
            }
        }

        if(state.error.isBlank())
            Text(
                text = state.error,
                textAlign = TextAlign.Center
            )

        if(state.isLoging)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator()
            }


    }
}