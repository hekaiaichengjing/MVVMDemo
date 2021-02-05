package com.xinruan.mvvmdemo.ui.fragment

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.xinruan.mvvmbase.fragment.BaseFragment
import com.xinruan.mvvmdemo.BR
import com.xinruan.mvvmdemo.R
import com.xinruan.mvvmdemo.databinding.FragmentMeBinding
import com.xinruan.mvvmloadsirbase.fragment.BaseLoadSirFragment

class MyFragment : BaseLoadSirFragment<FragmentMeBinding, MyFragViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_me
    }

    override fun getRealViewModel(): MyFragViewModel {
        return ViewModelProvider(this).get(MyFragViewModel::class.java);
    }

    override fun doOnCreate() {
//        viewModel.getData()
        dataBinding.tv.setOnClickListener {
            showLoading()
        }
    }

    override fun getDBVariableId(): Int {
        return BR.frag_vm
    }

    override fun onRetryBtnClick() {

    }

    override fun getLoadSirAttathView(): View = dataBinding.root


}