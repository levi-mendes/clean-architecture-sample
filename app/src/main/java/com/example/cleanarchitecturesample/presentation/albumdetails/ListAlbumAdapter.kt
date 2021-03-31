package com.example.cleanarchitecturesample.presentation.albumdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturesample.R
import com.example.cleanarchitecturesample.domain.entity.AlbumEntity

class ListAlbumAdapter(
    private val items: List<AlbumEntity>,
    private val listener: OnSelectListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class OriginalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var name: TextView = v.findViewById<View>(R.id.tv_title) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)

        return OriginalViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is OriginalViewHolder) {
            val view = holder
            val album = items[position]
            view.name.text = album.title
            holder.itemView.setOnClickListener { listener.onItemClick(album) }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}