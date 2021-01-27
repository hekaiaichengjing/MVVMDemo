package com.xinruan.mvvmdemo.ui.actitivty

import com.xinruan.mvvmbase.vm.BaseModel
import com.xinruan.mvvmdemo.ui.net.myInterface
import com.xinruan.netbase_api.respance.BaseResponse

class MainActivityModel : BaseModel() {
    //业务代码获取网络数据 和 数据处理 等耗时操作 用到了协程 所以函数前面加 suspend 将函数挂起 不然没有作用
    suspend fun getData(): BaseResponse {
        return myInterface.test()
    }

}