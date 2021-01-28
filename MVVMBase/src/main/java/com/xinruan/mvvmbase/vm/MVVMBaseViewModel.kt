package com.xinruan.mvvmbase.vm

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.xinruan.mvvmbase.inter.IBaseView
import kotlinx.coroutines.Dispatchers
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

    //生命周期随viewmodel
    fun <T> request(
        requestId: Int,
        block: suspend () -> T,
        suc: (id: Int, t: T) -> Unit,
        fail: (id: Int, throwable: Throwable) -> Unit
    ): Job {
        return viewModelScope.launch(Dispatchers.Default) {
            runCatching {
                block()
            }.onSuccess {
                viewModelScope.launch(Dispatchers.Main) {
                    suc(requestId, it)
                }
            }.onFailure {
                viewModelScope.launch(Dispatchers.Main) {
                    fail(requestId, it)
                }


            }

        }
    }

    //具有Activity和Fragment生命周期的
    fun <T> requestLifeCycle(
        requestId: Int,
        block: suspend () -> T,
        suc: (id: Int, t: T) -> Unit,
        fail: (id: Int, throwable: Throwable) -> Unit
    ): Job? {
        return dataBinding.lifecycleOwner?.lifecycleScope?.run {
            launch(Dispatchers.Default) {
                runCatching {
                    block()
                }.onSuccess {
                    launchWhenResumed {
                        suc(requestId, it)
                    }
                }.onFailure {
                    launchWhenResumed {
                        fail(requestId, it)
                    }
                }
            }
        }


    }
}