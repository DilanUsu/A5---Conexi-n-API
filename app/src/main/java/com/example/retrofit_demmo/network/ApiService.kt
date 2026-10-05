package com.example.retrofit_demmo.network

import com.example.retrofit_demmo.model.Coffee
import retrofit2.http.GET

/**
 * Interfaz que define las peticiones HTTP utilizando anotaciones de Retrofit.
 */
interface ApiService {

    /**
     * Obtiene el listado completo de cafés calientes.
     */
    @GET("coffee/hot")
    suspend fun getCoffees(): List<Coffee>
}
