package com.example.retrofit_demmo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Singleton para instanciar y configurar el cliente de Retrofit.
 */
object RetrofitClient {
    private const val BASE_URL = "https://api.sampleapis.com/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
