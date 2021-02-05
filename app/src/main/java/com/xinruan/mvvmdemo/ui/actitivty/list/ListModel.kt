package com.xinruan.mvvmdemo.ui.actitivty.list

import com.xinruan.mvvmbase.vm.BaseModel
import kotlinx.coroutines.delay

class ListModel : BaseModel() {

    suspend fun getData(): ArrayList<String> {
        delay(3000)
        return arrayListOf("我是第一", "我是第二", "我是第3", "我是第444", "我是第55555", "我是第646", "我是第757", "t", "我是第tt3", "fgdfgd", "我是第55555", "我是第34343", "我是第77")
    }

}