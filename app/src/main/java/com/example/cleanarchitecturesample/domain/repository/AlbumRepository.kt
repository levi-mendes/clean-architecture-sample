package com.example.cleanarchitecturesample.domain.repository

import com.example.cleanarchitecturesample.domain.entity.AlbumDetailsEntity
import com.example.cleanarchitecturesample.domain.entity.AlbumEntity
import com.example.cleanarchitecturesample.domain.entity.RequestState

interface AlbumRepository {

    suspend fun list(): RequestState<List<AlbumEntity>>

    suspend fun details(id: Int): RequestState<AlbumDetailsEntity>

    suspend fun photoUrl(): RequestState<String>
}