package com.example.cleanarchitecturesample.data

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

class ChalangeApi(retrofit: Retrofit) {

    private val service by lazy {
        retrofit.create(ChalangeService::class.java)
    }

    interface ChalangeService {

        @GET("albums")
        suspend fun list(): List<AlbumDTO>

        @GET("photos")
        suspend fun details(@Query("albumId") id: Int): AlbumDetailsDTO
    }
}