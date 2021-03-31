package com.example.cleanarchitecturesample.presentation.albumdetails

import com.example.cleanarchitecturesample.domain.entity.AlbumEntity

interface OnSelectListener {

    fun onItemClick(item: AlbumEntity)
}