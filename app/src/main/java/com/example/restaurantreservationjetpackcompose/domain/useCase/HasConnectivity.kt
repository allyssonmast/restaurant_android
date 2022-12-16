package com.example.restaurantreservationjetpackcompose.domain.useCase

import com.example.restaurantreservationjetpackcompose.common.AppStatus
import javax.inject.Inject

class HasConnectivity @Inject constructor(
    var appStatus: AppStatus
) {
    fun isConnected(): Boolean{
        return appStatus.isOnline()
    }
}