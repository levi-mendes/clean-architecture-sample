package com.example.cleanarchitecturesample.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturesample.domain.entity.AlbumEntity
import com.example.cleanarchitecturesample.domain.entity.RequestState
import com.example.cleanarchitecturesample.domain.usercases.ListAlbumsUserCase
import kotlinx.coroutines.launch

class MainViewModel(
    private val userCase: ListAlbumsUserCase
): ViewModel() {

    val albums = MutableLiveData<RequestState<List<AlbumEntity>>>()

    init {
        viewModelScope.launch {
            albums.value = userCase.list()
        }
    }
}