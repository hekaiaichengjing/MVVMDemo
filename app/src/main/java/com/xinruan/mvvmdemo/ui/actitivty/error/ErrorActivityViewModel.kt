package com.xinruan.mvvmdemo.ui.actitivty.error


import androidx.databinding.ObservableField

import com.xinruan.mvvmbase.vm.BaseModel
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import com.xinruan.mvvmdemo.databinding.ActivityErrorBinding

class ErrorActivityViewModel : MVVMBaseViewModel<BaseModel, ActivityErrorBinding>() {


    var count_msg = ObservableField<String>()

    fun ErrorActivityViewModel.reOpen() {


    }




}