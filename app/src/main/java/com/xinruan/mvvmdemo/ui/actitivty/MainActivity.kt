package com.xinruan.mvvmdemo.ui.actitivty

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.xinruan.mvvmbase.activity.BaseActivity
import com.xinruan.mvvmdemo.BR
import com.xinruan.mvvmdemo.R
import com.xinruan.mvvmdemo.databinding.ActivityMainBinding
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getRealViewModel(): MainActivityViewModel {
        return ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private var startTime: Long = 0
    override fun doOnCreate() {
        viewModel.getData()
        dataBinding.et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                println("=============> ${viewModel.msg2.get()}")
            }

        })
        startTime = System.currentTimeMillis()
        viewModel.viewModelScope.launch {
            test()
        }
    }

    //先后顺序
    private suspend fun test() {

        val job1 = withContext(viewModel.viewModelScope.coroutineContext) {
            delay(2000)
            "我是2000"
        }

        val job2 = withContext(viewModel.viewModelScope.coroutineContext) {
            delay(5000)
            "我是5000"
        }

        println("-----> ${job1}============${job2}--$startTime--${System.currentTimeMillis()}-耗时=${System.currentTimeMillis() - startTime}------------")

    }

    override fun getDBVariableId(): Int {
        return BR.vm
    }

    override fun showLoading() {
        super.showLoading()

    }

    override fun showContent() {
        super.showContent()

    }
}