package com.example.data.di

import com.example.data.remote.NetworkConfig
import com.example.data.remote.services.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

    @Provides
    fun provideRetrofit(): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(NetworkConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())


    @Provides
    fun provideWeatherService(retrofit : Retrofit.Builder): WeatherService =
        retrofit
            .build()
            .create(WeatherService::class.java)
}