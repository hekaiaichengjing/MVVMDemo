package com.xinruan.mvvmdemo.ui.actitivty

import androidx.databinding.ObservableField
import androidx.lifecycle.viewModelScope
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import com.xinruan.mvvmdemo.databinding.ActivityMainBinding
import com.xinruan.netbase_api.ResultState
import com.xinruan.netbase_api.error.ExceptionHandler
import com.xinruan.netbase_api.respance.BaseResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class MainActivityViewModel : MVVMBaseViewModel<MainActivityModel, ActivityMainBinding>(),
    ResultState<BaseResponse> {
    val msg: ObservableField<String> =
        ObservableField("我是初始化")//ObservableField 属性改变databinding会更新数据到界面
    val msg2: ObservableField<String> =
        ObservableField("我是初始化2")//双向绑定在布局中添加 = 号 （ android:text="@={vm.msg2}"）

    init {
        model = MainActivityModel()
    }

    fun getData() {
        var job = request(
            1,
            { model.getData() },
            { i: Int, baseRespance: BaseResponse -> loadedSuc(i, baseRespance) },
            { id: Int, throwable: Throwable -> loadedFail(id, throwable) })

    }

    override fun loadedSuc(requestId: Int, t: BaseResponse) {
        println("----------请求成功---------$requestId--------------${Thread.currentThread().name}-->")
    }


    override fun loadedFail(requestId: Int, throwable: Throwable) {
        println(
            "---------请求失败---------$requestId---------${
                ExceptionHandler.handleException(
                    throwable
                ).code
            }---${ExceptionHandler.handleException(throwable).message}---->"
        )

    }
}