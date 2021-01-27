package com.xinruan.mvvmdemo.ui.fragment

import com.xinruan.mvvmbase.vm.BaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyFragModel : BaseModel() {
    //业务代码获取网络数据 和 数据处理
    fun getData() {
        GlobalScope.launch(Dispatchers.Main) {
            delay(5000)
            println("获取网络数据了")
            loadSuc(1, "Fragment 的网络数据")
        }
    }
}