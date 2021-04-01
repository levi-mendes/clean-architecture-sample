package com.example.cleanarchitecturesample.data.remote

import com.example.cleanarchitecturesample.data.ChalangeApi
import com.example.cleanarchitecturesample.domain.entity.AlbumDetailsEntity
import com.example.cleanarchitecturesample.domain.entity.AlbumEntity
import com.example.cleanarchitecturesample.domain.entity.RequestState

class AlbumRemoteDataSourceImpl(private val api: ChalangeApi): AlbumRemoteDataSource {

    override suspend fun list(): List<AlbumEntity>{
        val apiReturn = api.list()

        return apiReturn.map {
            //val id: Int, val userId: Int, val title: String
            AlbumEntity(
                 it.id,
                it.userId,
                it.title
            )
        }
    }


    override suspend fun details(id: Int): AlbumDetailsEntity {
        TODO("Not yet implemented")
    }

    override suspend fun photoUrl(): String {
        TODO("Not yet implemented")
    }


}