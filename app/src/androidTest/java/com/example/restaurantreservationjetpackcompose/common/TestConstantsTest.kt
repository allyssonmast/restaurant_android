package com.example.restaurantreservationjetpackcompose.common

import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.*

object TestConstantsTest{
     val BASE_URL= MockWebServer().url("").toString()

}