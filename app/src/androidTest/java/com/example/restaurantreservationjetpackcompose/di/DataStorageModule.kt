package com.example.restaurantreservationjetpackcompose.di

import android.content.Context
import com.example.restaurantreservationjetpackcompose.common.AppStatus
import com.example.restaurantreservationjetpackcompose.common.FileStorageUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestDataStorageModule {

    @Singleton
    @Provides
    fun getFileStorage(@ApplicationContext context: Context): FileStorageUtil {
        return FileStorageUtil(context)
    }
    @Singleton
    @Provides
    fun getConnectivityInterceptor(@ApplicationContext context: Context): AppStatus {
        return AppStatus(context)
    }
}