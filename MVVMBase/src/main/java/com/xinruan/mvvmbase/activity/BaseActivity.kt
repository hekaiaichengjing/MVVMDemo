package com.xinruan.mvvmbase.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.lifecycleScope
import com.xinruan.mvvmbase.inter.IBaseView
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel

abstract class BaseActivity<DB : ViewDataBinding, VM : MVVMBaseViewModel<*, DB>> :
    AppCompatActivity(),
    IBaseView {
    lateinit var dataBinding: DB
    lateinit var viewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        doOnCreate()
    }

    abstract fun getLayoutId(): Int
    abstract fun getRealViewModel(): VM
    abstract fun doOnCreate()
    abstract fun getDBVariableId(): Int
    private fun initDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, getLayoutId())
        dataBinding.lifecycleOwner = this//databinding 添加生命周期监听 界面不为可见状态 不会刷新界面
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = getRealViewModel()
        this.viewModel?.let {
            it.assignUiListener(this)
            it.assignDBinding(dataBinding)
            if (getDBVariableId() > 0) {
                dataBinding.setVariable(getDBVariableId(), viewModel)
            }
        }

    }


    override fun showContent() {
    }

    override fun showLoading() {
    }

    override fun showEmpty() {


    }

    override fun showError() {

    }

    override fun onRefreshEmpty() {
    }

    override fun onRefreshFailure(msg: String) {
    }
}