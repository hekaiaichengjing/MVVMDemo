package com.xinruan.mvvmdemo.ui.fragment

import androidx.lifecycle.ViewModelProvider
import com.xinruan.mvvmbase.fragment.BaseFragment
import com.xinruan.mvvmdemo.BR
import com.xinruan.mvvmdemo.R
import com.xinruan.mvvmdemo.databinding.FragmentMeBinding

class MyFragment : BaseFragment<FragmentMeBinding, MyFragViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_me
    }

    override fun getRealViewModel(): MyFragViewModel {
        return ViewModelProvider(this).get(MyFragViewModel::class.java);
    }

    override fun doOnCreate() {
        viewModel.getData()
    }

    override fun getDBVariableId(): Int {
        return BR.frag_vm
    }
}