package com.example.studying.data

import android.content.ContentValues.TAG
import android.util.Log
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("catalog")
    suspend fun getAppList(): Response<List<AppDto>>
    //suspend fun getAppList(): List<AppDto>
}

class AppListApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://185.103.109.134/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(ApiService::class.java)

    suspend fun get(): List<AppDto> {
        var apps = listOf(
            AppDto(
                "fa2e31b8-1234-4cf7-9914-108a170a1b01",
                "QuickNote",
                "QuickNote — практичное приложение для хранения, организации и быстрой фиксации идей.",
                "Производительность",
                "https://fastly.picsum.photos/id/237/200/200.jpg?hmac=zHUGikXUDyLCCmvyww1izLK3R3k8oRYBRiTizZEdyfI",
                ),
        )
        //apps = apiService.getAppList()
        val response = apiService.getAppList()
        if (response.isSuccessful && response.body() != null) {
            apps = response.body()!!
        } else {
            Log.e(TAG,  "Ошибка: ${response.code()} - ${response.message()}")
        }
        return apps
    }
}