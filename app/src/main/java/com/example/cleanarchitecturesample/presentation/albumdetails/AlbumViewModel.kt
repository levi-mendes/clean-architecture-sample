package com.example.cleanarchitecturesample.presentation.albumdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturesample.domain.entity.AlbumDetailsEntity
import com.example.cleanarchitecturesample.domain.entity.RequestState
import com.example.cleanarchitecturesample.domain.usercases.GetDetailsUserCause
import kotlinx.coroutines.launch

class AlbumViewModel(private val userCase: GetDetailsUserCause) : ViewModel() {

    val details = MutableLiveData<RequestState<AlbumDetailsEntity>>()

    fun getDetails(id: Int) {
        viewModelScope.launch {
            val albumDetails = userCase.getDetails(id = id)

            details.value = albumDetails
        }
    }
}