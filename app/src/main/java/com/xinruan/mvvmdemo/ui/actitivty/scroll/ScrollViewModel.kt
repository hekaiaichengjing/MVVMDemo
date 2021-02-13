package com.xinruan.mvvmdemo.ui.actitivty.scroll

import com.xinruan.mvvmbase.vm.BaseModel
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import com.xinruan.mvvmdemo.databinding.ActivityScrollBinding

class ScrollViewModel : MVVMBaseViewModel<BaseModel, ActivityScrollBinding>() {
    var adapter = ScrollAdapter()

    init {
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")
        adapter.addItem("我是第一个啊哈哈哈哈")


    }
}