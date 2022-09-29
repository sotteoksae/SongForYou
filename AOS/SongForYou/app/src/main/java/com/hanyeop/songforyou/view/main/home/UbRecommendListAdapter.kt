package com.hanyeop.songforyou.view.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hanyeop.songforyou.databinding.ItemChartBinding
import com.hanyeop.songforyou.model.response.SongResponse

class UbRecommendListAdapter(): ListAdapter<SongResponse, UbRecommendListAdapter.ViewHolder>(diffUtil){


    inner class ViewHolder(private val binding: ItemChartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(song: SongResponse) {
            binding.song = song
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemChartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<SongResponse>() {
            override fun areItemsTheSame(oldItem: SongResponse, newItem: SongResponse): Boolean {
                return oldItem.SongSeq == newItem.SongSeq
            }

            override fun areContentsTheSame(oldItem: SongResponse, newItem: SongResponse): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    }
}
