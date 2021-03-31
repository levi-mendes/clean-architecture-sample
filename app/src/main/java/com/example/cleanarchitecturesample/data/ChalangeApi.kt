package com.example.cleanarchitecturesample.data

import retrofit2.Retrofit
import retrofit2.http.GET

class ChalangeApi(retrofit: Retrofit) {

    private val service by lazy {
        retrofit.create(ChalangeService::class.java)
    }

    //suspend fun list() =

    interface ChalangeService {

        @GET
        suspend fun list(): List<AlbumDTO>

        @GET
        suspend fun details(id: Int): AlbumDetailsDTO
    }
}