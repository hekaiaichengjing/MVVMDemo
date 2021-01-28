package com.xinruan.mvvmbase.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.xinruan.mvvmbase.inter.IBaseView
import com.xinruan.mvvmbase.vm.MVVMBaseViewModel

abstract class BaseFragment<DB : ViewDataBinding, VM : MVVMBaseViewModel<*, DB>> : Fragment(),
    IBaseView {
    lateinit var dataBinding: DB
    lateinit var viewModel: VM
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        dataBinding.lifecycleOwner = this
        return dataBinding.root
    }

    abstract fun getLayoutId(): Int
    abstract fun getRealViewModel(): VM
    abstract fun doOnCreate()
    abstract fun getDBVariableId(): Int
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = getRealViewModel()
        viewModel?.let {
            it.assignDBinding(dataBinding)
            it.assignUiListener(this)

            if (getDBVariableId() > 0) {
                dataBinding.setVariable(getDBVariableId(), viewModel)
            }
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        doOnCreate()
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