package com.xinruan.mvvmloadsirbase.activity

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.xinruan.mvvmbase.activity.BaseActivity
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.EmptyCallback
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.ErrorCallback
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.LoadingCallback

abstract class BaseLoadSirActivity<DB : ViewDataBinding, VM : MVVMBaseViewModel<*, DB>> :
    BaseActivity<DB, VM>() {
    private var loadService: LoadService<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        doAfterOnCreate()
    }

    override fun doOnCreate() {
        loadService = LoadSir.getDefault().register(dataBinding.root) { onRetryBtnClick() }
    }

    abstract fun doAfterOnCreate()

    //更换LoadSir加载再具体的View上
    fun setLoadSirView(view: View) {
        loadService = LoadSir.getDefault().register(view) { onRetryBtnClick() }
    }

    override fun showContent() {
        super.showContent()
        loadService?.showSuccess()
    }

    override fun showLoading() {
        super.showLoading()
        dataBinding.root.post {
            loadService?.showCallback(LoadingCallback::class.java)
        }

    }

    override fun showEmpty() {
        super.showEmpty()

        dataBinding.root.post {
            loadService?.showCallback(EmptyCallback::class.java)
        }
    }

    override fun showError() {
        super.showError()

        dataBinding.root.post {
            loadService?.showCallback(ErrorCallback::class.java)
        }
    }

    abstract fun onRetryBtnClick()
}