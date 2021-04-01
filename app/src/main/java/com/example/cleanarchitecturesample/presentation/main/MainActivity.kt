package com.example.cleanarchitecturesample.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturesample.R
import com.example.cleanarchitecturesample.domain.entity.AlbumEntity
import com.example.cleanarchitecturesample.domain.entity.RequestState
import com.example.cleanarchitecturesample.presentation.ViewModelFactory
import com.example.cleanarchitecturesample.presentation.albumdetails.ListAlbumAdapter
import com.example.cleanarchitecturesample.presentation.albumdetails.OnSelectListener
import com.example.cleanarchitecturesample.presentation.base.BaseActivity

class MainActivity : BaseActivity(), OnSelectListener {

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configList()

        viewModel.albums.observe(this, Observer {
            when (it) {
                is RequestState.Success -> {
                    hideLoading()
                    loadList(it.data)
                }
                is RequestState.Loading -> showLoading()
                is RequestState.Error   -> showError()
            }
        })
    }

    private fun configList() {
        val rvAlbums = findViewById<RecyclerView>(R.id.rv_albums)
        rvAlbums.layoutManager = LinearLayoutManager(this)
        rvAlbums.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        rvAlbums.setHasFixedSize(true)
    }

    private fun hideLoading() {
        findViewById<ProgressBar>(R.id.pb_loading).visibility = INVISIBLE
    }

    private fun showLoading() {
        findViewById<ProgressBar>(R.id.pb_loading).visibility = VISIBLE
    }

    private fun showError() {

    }

    private fun loadList(list: List<AlbumEntity>) {
        val rvAlbums = findViewById<RecyclerView>(R.id.rv_albums)
        val adapter = ListAlbumAdapter(list, this)
        rvAlbums.adapter = adapter
    }

    override fun onItemClick(item: AlbumEntity) {

    }
}