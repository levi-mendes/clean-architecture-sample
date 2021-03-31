package com.example.cleanarchitecturesample.presentation.photo

import android.os.Bundle
import com.example.cleanarchitecturesample.R
import com.example.cleanarchitecturesample.presentation.base.BaseActivity

class PhotoActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
    }
}