package com.example.cleanarchitecturesample.presentation.album

import android.os.Bundle
import com.example.cleanarchitecturesample.R
import com.example.cleanarchitecturesample.presentation.base.BaseActivity

class AlbumActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
    }
}