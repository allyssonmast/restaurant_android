package com.example.restaurantreservationjetpackcompose.di

import com.example.restaurantreservationjetpackcompose.common.Constants.BASE_URL
import com.example.restaurantreservationjetpackcompose.data.tables.remote.RestaurantApi
import com.example.restaurantreservationjetpackcompose.data.tables.repository.RepositoryRestaurantImp
import com.example.restaurantreservationjetpackcompose.domain.repositories.IRestaurantRepository
import com.example.restaurantreservationjetpackcompose.domain.useCase.GetCustomers
import com.example.restaurantreservationjetpackcompose.domain.useCase.GetReservations
import com.example.restaurantreservationjetpackcompose.domain.useCase.GetTables
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RestaurantModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor():HttpLoggingInterceptor  {
        val logging = HttpLoggingInterceptor()
        logging.apply {
            logging.level = HttpLoggingInterceptor.Level.BODY
        }
        return logging
    }

    @Provides
    @Singleton
    fun  provideHttpClient(): OkHttpClient.Builder {
        val httpClient = OkHttpClient.Builder()
        val logging = provideLoggingInterceptor()

        httpClient.addInterceptor(logging);
        return httpClient;
    }

    @Provides
    @Singleton
    fun provideRestaurantApi(): RestaurantApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(RestaurantApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRestaurantRepository(api: RestaurantApi): IRestaurantRepository{
        return RepositoryRestaurantImp(api)
    }

    @Provides
    @Singleton
    fun provideGetTables(repository: IRestaurantRepository):GetTables{
        return GetTables(repository)
    }

    @Provides
    @Singleton
    fun provideGetCustomers(repository: IRestaurantRepository):GetCustomers{
        return GetCustomers(repository)
    }

    @Provides
    @Singleton
    fun provideGetReservation(repository: IRestaurantRepository):GetReservations{
        return GetReservations(repository)
    }

}