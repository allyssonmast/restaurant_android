package com.example.restaurantreservationjetpackcompose.presetation.customers.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.restaurantreservationjetpackcompose.domain.entities.Customer


@Composable
fun CustomerItem(
    customer: Customer,
    onItemClick:(Customer) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(customer) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = customer.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = customer.firstName + " " + customer.lastName,
            style = MaterialTheme.typography.bodyMedium
        )
    }

}