package com.example.cleanarchitecturesample.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarchitecturesample.domain.entity.AlbumEntity
import com.example.cleanarchitecturesample.domain.usercases.ListAlbumsUserCase

class MainViewModel(
    private val userCase: ListAlbumsUserCase
): ViewModel() {

    val albums = MutableLiveData<List<AlbumEntity>>()

    fun list() {
        //val list = userCase.list()

        //albums.postValue(list)
    }
}