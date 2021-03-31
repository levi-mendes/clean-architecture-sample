package com.example.cleanarchitecturesample.presentation.photo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturesample.domain.entity.RequestState
import com.example.cleanarchitecturesample.domain.usercases.GetPhotoUserCase
import kotlinx.coroutines.launch

class PhotoViewModel(private val userCase: GetPhotoUserCase) : ViewModel() {

    val photo = MutableLiveData<RequestState<String>>()

    fun getPhoto() {
        viewModelScope.launch {
            photo.value = userCase.getPhoto()
        }
    }
}