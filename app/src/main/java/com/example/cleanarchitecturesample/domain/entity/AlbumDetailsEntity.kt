package com.example.cleanarchitecturesample.domain.entity

data class AlbumDetailsEntity(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)