package com.example.restaurantreservationjetpackcompose.presetation.tables.ui
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.restaurantreservationjetpackcompose.MainActivity
import com.example.restaurantreservationjetpackcompose.common.Constants
import com.example.restaurantreservationjetpackcompose.common.Screen
import com.example.restaurantreservationjetpackcompose.common.theme.RestaurantReservationJetpackComposeTheme
import com.example.restaurantreservationjetpackcompose.di.RestaurantModule
import dagger.hilt.android.testing.HiltAndroidRule

import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(RestaurantModule::class)
class TablesScreenKtTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeRule= createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent {
            val navController= rememberNavController()
            RestaurantReservationJetpackComposeTheme {
                NavHost(
                    navController = navController,
                    startDestination = Screen.TablesScreen.route
                ){
                    composable(route=Screen.TablesScreen.route){
                        TablesSreen(navController = navController)
                    }
                }
            }
        }
    }

    @Test
    fun clickToggleOrderSection_isVisible(){
        composeRule.onNodeWithTag(Constants.TITLE).assertDoesNotExist()
        composeRule.onNodeWithTag(Constants.DIALOG).assertExists()
    }

}