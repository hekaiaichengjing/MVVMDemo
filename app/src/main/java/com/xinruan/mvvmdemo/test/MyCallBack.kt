package com.xinruan.mvvmdemo.test

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

class MyCallBack : ItemTouchHelper.SimpleCallback {

    constructor(dragDirs: Int=0, swipeDirs: Int=15) : super(dragDirs, swipeDirs) {
    }


    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        TODO("Not yeted")
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        TODO("Not yet implemented")
    }
}