package com.xinruan.mvvmdemo.ui.actitivty.scroll

import android.view.LayoutInflater
import android.view.ViewGroup
import com.xinruan.mvvmbase.adapter.BaseRecyclerAdapter
import com.xinruan.mvvmdemo.DemoApplication
import com.xinruan.mvvmdemo.R

class ScrollAdapter : BaseRecyclerAdapter<String, ScrollHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScrollHolder {
        var view =
            LayoutInflater.from(DemoApplication.APP).inflate(R.layout.adapter_item, parent, false)
        println("----------viewType----> $viewType")
        if (viewType == 4) {
            view= LayoutInflater.from(DemoApplication.APP)
                .inflate(R.layout.adapter_scroll_item, parent, false)
        }
        return ScrollHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: ScrollHolder, position: Int) {

    }

}