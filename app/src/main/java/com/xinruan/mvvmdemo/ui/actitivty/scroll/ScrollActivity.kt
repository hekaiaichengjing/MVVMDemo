package com.xinruan.mvvmdemo.ui.actitivty.scroll

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xinruan.mvvmdemo.R
import com.xinruan.mvvmdemo.databinding.ActivityScrollBinding
import com.xinruan.mvvmloadsirbase.activity.BaseLoadSirActivity

class ScrollActivity : BaseLoadSirActivity<ActivityScrollBinding, ScrollViewModel>() {
    override fun doAfterOnCreate() {
        dataBinding.rlScroll.layoutManager = LinearLayoutManager(this)
        dataBinding.rlScroll.adapter = viewModel.adapter

    }

    override fun onRetryBtnClick() {
    }

    override fun getLayoutId(): Int = R.layout.activity_scroll
    override fun getRealViewModel(): ScrollViewModel =
        ViewModelProvider(this).get(ScrollViewModel::class.java)

    override fun getDBVariableId(): Int {
        return 0
    }
}