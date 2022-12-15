package com.example.restaurantreservationjetpackcompose.presetation.tables.ui


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.restaurantreservationjetpackcompose.domain.entities.Customer
import com.example.restaurantreservationjetpackcompose.domain.entities.Table

@Composable
fun TableItem(
    table: Table,
    customer: Customer?,
    onItemClick:(Table) ->Unit
){
    var imageVector= com.example.restaurantreservationjetpackcompose.R.drawable.ic_rectangle
    when(table.shape){
        "circle"-> {
            imageVector= com.example.restaurantreservationjetpackcompose.R.drawable.ic_circle
        }
        "square" ->{
            imageVector= com.example.restaurantreservationjetpackcompose.R.drawable.ic_square
        }
    }
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(table) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(imageVector),
            contentDescription = "",
            modifier = Modifier.size(50.dp)
        )
        Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Table Id",
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    text = table.id.toString(),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text(
                text = "ReservedBy",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = customer?.firstName ?: "Free",
                style = MaterialTheme.typography.bodyMedium
            )

        }

        AsyncImage(
            model = customer?.imageUrl,
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )

    }
}