package com.xinruan.mvvmbase.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {
    var datas = arrayListOf<T>()

    fun addItem(t: T) {
        datas.add(t)
        notifyDataSetChanged()
    }

    fun removeItem(t: T) {
        datas.remove(t)
        notifyDataSetChanged()
    }

    fun getItemByPosition(position: Int): T {
        return datas[position]
    }

    fun removeItemByIndex(index: Int) {
        if (index >= 0 && index < datas.size)
            datas.removeAt(index)
        notifyDataSetChanged()
    }

    fun addList(list: ArrayList<T>) {
        datas.addAll(list)
        notifyDataSetChanged()
    }

    fun addItemByIndex(index: Int, t: T) {
        if (index >= 0 && index < datas.size)
            datas.add(index, t)
        notifyDataSetChanged()
    }

    fun removeAll() {
        datas.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = datas.size
}