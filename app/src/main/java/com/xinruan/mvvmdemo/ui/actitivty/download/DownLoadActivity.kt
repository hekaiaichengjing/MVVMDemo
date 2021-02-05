package com.xinruan.mvvmdemo.ui.actitivty.download

import androidx.lifecycle.ViewModelProvider
import com.xinruan.mvvmdemo.BR
import com.xinruan.mvvmdemo.R
import com.xinruan.mvvmdemo.databinding.ActivityDownloadBinding
import com.xinruan.mvvmloadsirbase.activity.BaseLoadSirActivity


class DownLoadActivity :
    BaseLoadSirActivity<ActivityDownloadBinding, DownLoadViewModel>() {
    val TAG = "hekai"
    override fun onRetryBtnClick() {
    }

    override fun getLayoutId(): Int = R.layout.activity_download


    override fun doOnCreate() {


    }

    override fun getDBVariableId(): Int {
        return BR.download_vm
    }

    override fun getRealViewModel(): DownLoadViewModel {
        return ViewModelProvider(this).get(DownLoadViewModel::class.java)
    }

    override fun doAfterOnCreate() {

    }
}