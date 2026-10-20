package com.example.memoria.presentation.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.memoria.databinding.MemoCardBinding
import com.example.memoria.databinding.MemoCardBinding.inflate
import com.example.memoria.domain.MemoEntity


class MemoCardListRecyclerViewAdapter(
    val list: List<MemoEntity>
): RecyclerView.Adapter<MemoCardListRecyclerViewAdapter.MemoCardViewHolder>() {

    private val TAG = "ViewAdapter"
    class MemoCardViewHolder(val binding: MemoCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MemoCardViewHolder {
        val binding = inflate(LayoutInflater.from(parent.context), parent, false)

        Log.i(TAG, "onCreateViewHolder is invoked!")

        return MemoCardViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MemoCardViewHolder,
        position: Int
    ) {

        Log.i(TAG, "onBindViewHolder is invoked! " + "list:" + list[position])

        holder.binding.apply {
            tvNameField.text = list[position].name
            tvDescField.text = list[position].description
        }
    }

    override fun getItemCount(): Int = list.size
}