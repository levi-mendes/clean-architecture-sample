package com.example.cleanarchitecturesample.data.remote

import com.example.cleanarchitecturesample.domain.entity.AlbumDetailsEntity
import com.example.cleanarchitecturesample.domain.entity.AlbumEntity
import com.example.cleanarchitecturesample.domain.entity.RequestState

interface AlbumRemoteDataSource {

    suspend fun list(): List<AlbumEntity>

    suspend fun details(id: Int): AlbumDetailsEntity

    suspend fun photoUrl(): String
}