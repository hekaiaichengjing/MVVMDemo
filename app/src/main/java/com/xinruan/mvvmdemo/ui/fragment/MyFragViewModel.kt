package com.xinruan.mvvmdemo.ui.fragment

import androidx.databinding.ObservableField
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import com.xinruan.mvvmdemo.databinding.FragmentMeBinding
import com.xinruan.netbase_api.ResultState
import com.xinruan.netbase_api.error.ExceptionHandler
import com.xinruan.netbase_api.respance.BaseResponse

class MyFragViewModel : MVVMBaseViewModel<MyFragModel, FragmentMeBinding>(),
    ResultState<BaseResponse> {
    init {
        model = MyFragModel()
    }

    val msg = ObservableField<String>("我是初始化")


    fun getData() {
        requestLifeCycle(
            1,
            { model.getData() },
            { id, t -> loadedSuc(id, t) },
            { id, throwable -> loadedFail(id, throwable) })
    }

    override fun loadedSuc(requestId: Int, t: BaseResponse) {
        println("---Fragment-------请求成功---------$requestId--------------${Thread.currentThread().name}-->")

    }



    override fun loadedFail(requestId: Int, throwable: Throwable) {

        println(
            "-----Fragment----请求失败---------$requestId---------${
                ExceptionHandler.handleException(
                    throwable
                ).code
            }---${ExceptionHandler.handleException(throwable).message}-----${Thread.currentThread().name}-->->"
        )
    }

}