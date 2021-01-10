package com.example.data.repository

import com.example.data.local.mapper.WeatherCacheMapper
import com.example.data.local.room.WeatherDao
import com.example.data.remote.NetworkConfig
import com.example.data.remote.NetworkEndpoints
import com.example.data.remote.mappers.WeatherNetworkMapper
import com.example.data.remote.models.WeatherNetworkEntity
import com.example.data.remote.services.WeatherService
import com.example.data.remote.utils.ApiResult
import com.example.data.remote.utils.safeCallApi
import com.example.domain.util.DataState
import com.example.domain.model.Weather
import com.example.domain.repository.WeatherRepository
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepositoryImp
@Inject
constructor(
    private val service: WeatherService,
    private val dao: WeatherDao,
    private val weatherNetworkMapper: WeatherNetworkMapper,
    private val weatherCacheMapper: WeatherCacheMapper
): WeatherRepository {
    @InternalCoroutinesApi
    override suspend fun getWeather(): Flow<DataState<Weather>> = flow {
        emit(DataState.Loading)
        val networkResult : ApiResult<WeatherNetworkEntity> = safeCallApi {
              service.getWeather(
                        NetworkEndpoints.LAT
                        ,NetworkEndpoints.LON
                        ,NetworkConfig.APP_ID,
                        NetworkEndpoints.UNITS)
         }

        when(networkResult){
            is ApiResult.Success -> {
                updateCache(networkResult.data)
                emit(DataState.Success(weatherNetworkMapper.mapFromEntity(networkResult.data)))
            }
            is ApiResult.Error -> {
                emit(DataState.Error(networkResult.errorState,networkResult.errorMessage))
                val cachedWeather = dao.getWeather()
                emit(DataState.Success(weatherCacheMapper.mapFromEntity(cachedWeather)))
            }
        }
    }

    private suspend fun updateCache(data: WeatherNetworkEntity) {
        dao.insert(weatherCacheMapper.mapToEntity(weatherNetworkMapper.mapFromEntity(data)))
    }

}