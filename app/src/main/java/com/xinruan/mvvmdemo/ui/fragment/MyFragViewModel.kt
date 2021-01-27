package com.xinruan.mvvmdemo.ui.fragment

import androidx.databinding.ObservableField
import com.xinruan.mvvmbase.vm.IBaseModelLisnter
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import com.xinruan.mvvmdemo.databinding.FragmentMeBinding

class MyFragViewModel : MVVMBaseViewModel<MyFragModel, FragmentMeBinding>(), IBaseModelLisnter {
    init {
        model = MyFragModel()
        model.register(this)
    }

    val msg = ObservableField<String>("我是初始化")
    override fun loadSuc(requestId: Int, any: Any) {
        val m = any as String
        msg.set(m)
    }

    override fun netFailed() {

    }

    fun getData() {
        model.getData()
    }
}