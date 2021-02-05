package com.xinruan.mvvmbase.adapter

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<DB : ViewDataBinding> : RecyclerView.ViewHolder {
    var databinding: DB

    constructor(view: View) : super(view) {
        databinding = DataBindingUtil.bind(view)!!
    }

}