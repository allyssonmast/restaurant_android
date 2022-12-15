package com.example.restaurantreservationjetpackcompose.presetation.customers.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.restaurantreservationjetpackcompose.presetation.customers.CustomersViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomersScreen(
    navController: NavController,
    viewModel: CustomersViewModel = hiltViewModel()
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
                    Text(text = "Customers")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
            )
        }
    ){ paddingValues ->
        LazyColumn(modifier =  Modifier.padding(paddingValues),){

            items(state.customers){ customer ->
                CustomerItem(
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
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator()
            }

    }
}