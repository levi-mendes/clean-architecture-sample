package com.example.cleanarchitecturesample.domain.usercases

import com.example.cleanarchitecturesample.domain.repository.AlbumRepository

class GetDetailsUserCause(private val repository: AlbumRepository) {

    suspend fun getDetails(id: Int) = repository.details(id)
}