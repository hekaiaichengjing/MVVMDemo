package com.xinruan.mvvmdemo.ui.actitivty.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.xinruan.mvvmbase.adapter.BaseRecyclerAdapter
import com.xinruan.mvvmdemo.DemoApplication
import com.xinruan.mvvmdemo.R

class ListAdapter : BaseRecyclerAdapter<String, ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var view =
            LayoutInflater.from(DemoApplication.APP).inflate(R.layout.adapter_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.databinding.tv.text = getItemByPosition(position)
    }

}