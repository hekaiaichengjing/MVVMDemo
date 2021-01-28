package com.xinruan.mvvmloadsirbase.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.kingja.loadsir.callback.SuccessCallback
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.xinruan.mvvmbase.fragment.BaseFragment
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.EmptyCallback
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.ErrorCallback
import me.hgj.jetpackmvvm.demo.app.weight.loadCallBack.LoadingCallback

abstract class BaseLoadSirFragment<DB : ViewDataBinding, VM : MVVMBaseViewModel<*, DB>> :
    BaseFragment<DB, VM>() {
    private var loadService: LoadService<*>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        dataBinding.lifecycleOwner = this
        loadService = LoadSir.getDefault().register(dataBinding.root) { onRetryBtnClick() }
        return loadService?.loadLayout
    }

    //设置loadSir依附于那个View之上
    abstract fun getLoadSirAttathView(): View

    override fun showContent() {
        super.showContent()
        loadService?.showSuccess()
    }

    override fun showLoading() {
        super.showLoading()
        loadService?.showCallback(LoadingCallback::class.java)
    }

    override fun showEmpty() {
        super.showEmpty()
        loadService?.showCallback(EmptyCallback::class.java)
    }

    override fun showError() {
        super.showError()
        loadService?.showCallback(ErrorCallback::class.java)
    }

    abstract fun onRetryBtnClick()
}