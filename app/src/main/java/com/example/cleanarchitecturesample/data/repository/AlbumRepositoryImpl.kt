package com.example.cleanarchitecturesample.data.repository

import com.example.cleanarchitecturesample.data.remote.AlbumRemoteDataSource
import com.example.cleanarchitecturesample.domain.entity.AlbumDetailsEntity
import com.example.cleanarchitecturesample.domain.entity.AlbumEntity
import com.example.cleanarchitecturesample.domain.entity.RequestState
import com.example.cleanarchitecturesample.domain.repository.AlbumRepository

class AlbumRepositoryImpl(
    private val remoteDataSource: AlbumRemoteDataSource
): AlbumRepository {

    override suspend fun list(): RequestState<List<AlbumEntity>> {
        return RequestState.Success(remoteDataSource.list())
    }

    override suspend fun details(id: Int): RequestState<AlbumDetailsEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun photoUrl(): RequestState<String> {
        TODO("Not yet implemented")
    }

}