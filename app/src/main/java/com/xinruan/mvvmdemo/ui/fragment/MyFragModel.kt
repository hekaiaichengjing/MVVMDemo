package com.xinruan.mvvmdemo.ui.fragment

import com.xinruan.mvvmbase.vm.BaseModel
import com.xinruan.mvvmdemo.ui.net.myInterface
import com.xinruan.netbase_api.respance.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyFragModel : BaseModel() {
    //业务代码获取网络数据 和 数据处理
    suspend fun getData(): BaseResponse {
        return myInterface.test()
    }
}