package com.example.mycrud

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.DELETE
import retrofit2.http.Path

interface WebService {
    @GET("/platillos")
    suspend fun getPlatillos(): Response<PlatillosResponse>

    @POST("/platillos")
    suspend fun addPlatillo(@Body platillo: Platillo): Response<PlatillosResponse>

    @PUT("platillos/{id}")
    suspend fun updatePlatillo(@Path("id") id_platillo: Int, @Body platillo: Platillo): Response<PlatillosResponse>

    @DELETE("/platiilos/{id}")
    suspend fun deletePlatillo(@Path("id") id_platillo: Int): Response<PlatillosResponse>

}