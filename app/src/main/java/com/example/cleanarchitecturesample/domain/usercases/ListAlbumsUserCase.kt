package com.example.cleanarchitecturesample.domain.usercases

import com.example.cleanarchitecturesample.domain.repository.AlbumRepository

class ListAlbumsUserCase(private val repository: AlbumRepository) {

    suspend fun list() = repository.list()
}