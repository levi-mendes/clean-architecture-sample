package com.example.cleanarchitecturesample.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchitecturesample.data.ChalangeApi
import com.example.cleanarchitecturesample.data.RetrofitInitializer
import com.example.cleanarchitecturesample.data.remote.AlbumRemoteDataSourceImpl
import com.example.cleanarchitecturesample.data.repository.AlbumRepositoryImpl
import com.example.cleanarchitecturesample.domain.repository.AlbumRepository
import com.example.cleanarchitecturesample.domain.usercases.GetDetailsUserCause
import com.example.cleanarchitecturesample.domain.usercases.GetPhotoUserCase
import com.example.cleanarchitecturesample.domain.usercases.ListAlbumsUserCase
import com.example.cleanarchitecturesample.presentation.albumdetails.AlbumViewModel
import com.example.cleanarchitecturesample.presentation.main.MainViewModel
import com.example.cleanarchitecturesample.presentation.photo.PhotoViewModel

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun api()        = ChalangeApi(retrofit())
    private fun retrofit()   = RetrofitInitializer().create()
    private fun remoteDataSource() = AlbumRemoteDataSourceImpl(api())
    private fun repository() = AlbumRepositoryImpl(remoteDataSource())
    private val listUserCase = ListAlbumsUserCase(repository())
    private val getDetailsUserCause = GetDetailsUserCause(repository())
    private val getPhotoUserCase = GetPhotoUserCase(repository())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when(modelClass) {

        MainViewModel::class.java    -> {
            MainViewModel(listUserCase) as T

        } PhotoViewModel::class.java -> {
            PhotoViewModel(getPhotoUserCase) as T

        } else -> {
            AlbumViewModel(getDetailsUserCause) as T
        }
    }

}

/*
class ListViewModelFactory (
    private val getItemsUseCase: GetItemsUseCase,
    private val getUserLoggedUseCase: GetUserLoggedUseCase,
    private val deleteItemUseCase: DeleteItemUseCase
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GetItemsUseCase::class.java, GetUserLoggedUseCase::class.java, DeleteItemUseCase::class.java
        ).newInstance(getItemsUseCase, getUserLoggedUseCase, deleteItemUseCase)
    }
}
 */