package com.xinruan.mvvmdemo.ui.actitivty.list

import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.xinruan.mvvmdemo.R
import com.xinruan.mvvmdemo.databinding.ActivityListBinding
import com.xinruan.mvvmloadsirbase.activity.BaseLoadSirActivity

class ListActivity : BaseLoadSirActivity<ActivityListBinding, ListActivtyViewModel>() {
    override fun onRetryBtnClick() {
    }

    override fun getLayoutId(): Int = R.layout.activity_list
    override fun getRealViewModel(): ListActivtyViewModel =
        ViewModelProvider(this).get(ListActivtyViewModel::class.java)


    override fun getDBVariableId(): Int {
        return 0
    }

    override fun doAfterOnCreate() {
        dataBinding.rlList.layoutManager = LinearLayoutManager(this)
        dataBinding.rlList.adapter = viewModel.adapter

        viewModel.getData()
    }
}