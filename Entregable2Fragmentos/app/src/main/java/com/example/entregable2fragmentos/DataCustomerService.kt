package com.example.entregable2fragmentos

import retrofit2.http.GET

interface DataCustomerService {

    @GET("films")
    suspend fun getProperties(): List<Propiedades>

}