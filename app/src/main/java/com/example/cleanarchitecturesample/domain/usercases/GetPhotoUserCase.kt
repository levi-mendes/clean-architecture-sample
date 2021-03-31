package com.example.cleanarchitecturesample.domain.usercases

import com.example.cleanarchitecturesample.domain.repository.AlbumRepository

class GetPhotoUserCase(private val repository: AlbumRepository) {

    suspend fun getPhoto() = repository.photoUrl()
}