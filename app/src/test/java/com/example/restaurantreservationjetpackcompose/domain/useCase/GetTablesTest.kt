package com.example.restaurantreservationjetpackcompose.domain.useCase

import com.example.restaurantreservationjetpackcompose.data.repository.FakeRepository
import com.example.restaurantreservationjetpackcompose.domain.entities.Table
import org.junit.Before
import org.junit.Test

class GetTablesTest{

    private lateinit var getTables: GetTables
    private lateinit var fakeRepository: FakeRepository
    @Before
    fun setUp(){
        fakeRepository = FakeRepository()
        getTables = GetTables(fakeRepository)

        val tablesList= mutableListOf<Table>()

        (1 .. 10).filterIndexed{ index,c ->
            tablesList.add(
                Table(
                    id = 100+index,
                    shape = "squad",
                    reserveBy = null
                )
            )

        }

        tablesList.shuffle()
    }

}