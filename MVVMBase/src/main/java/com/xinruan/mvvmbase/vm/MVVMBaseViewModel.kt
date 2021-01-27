package com.xinruan.mvvmbase.vm

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xinruan.mvvmbase.inter.IBaseView
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

abstract class MVVMBaseViewModel<M : BaseModel, DB : ViewDataBinding> : ViewModel() {
    lateinit var model: M
    lateinit var dataBinding: DB
    lateinit var lisnter: IBaseView
    fun assignDBinding(dataBinding: DB) {
        this.dataBinding = dataBinding
    }


    fun assignUiListener(lisnter: IBaseView) {
        this.lisnter = lisnter
    }


    fun <T> request(
        requestId: Int,
        block: suspend () -> T,
        suc: (id: Int, t: T) -> Unit,
        fail: (id: Int, throwable: Throwable) -> Unit
    ): Job {
        return viewModelScope.launch {
            runCatching {
                block()
            }.onSuccess {
                suc(requestId, it)
            }.onFailure {
                fail(requestId, it)
            }

        }
    }
}