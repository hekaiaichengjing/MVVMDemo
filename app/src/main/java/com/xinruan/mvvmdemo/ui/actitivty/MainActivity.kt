package com.xinruan.mvvmdemo.ui.actitivty

import android.content.Intent
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.xinruan.mvvmbase.BaseClickEvent
import com.xinruan.mvvmbase.activity.BaseActivity
import com.xinruan.mvvmdemo.BR
import com.xinruan.mvvmdemo.DemoApplication
import com.xinruan.mvvmdemo.R
import com.xinruan.mvvmdemo.databinding.ActivityMainBinding
import com.xinruan.mvvmdemo.process.MyProcessActivity
import com.xinruan.mvvmdemo.ui.actitivty.download.DownLoadActivity
import com.xinruan.mvvmdemo.ui.actitivty.list.ListActivity
import com.xinruan.mvvmloadsirbase.activity.BaseLoadSirActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.NullPointerException
import java.lang.ref.WeakReference

class MainActivity : BaseLoadSirActivity<ActivityMainBinding, MainActivityViewModel>() {

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
                if (TextUtils.equals(s, "1")) {
                    throw NullPointerException("我是故意的")
                }
            }

        })
        startTime = System.currentTimeMillis()
        viewModel.viewModelScope.launch {
            test()
        }
        //设置点击响应事件
        dataBinding.click = ClickProxy(this)
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

    //点击事件类 当然也可以统一写在ViewModel里面 具体看习惯
    class ClickProxy : BaseClickEvent {
        private var reference: WeakReference<MainActivity>

        constructor(mainActivity: MainActivity) {
            reference = WeakReference(mainActivity)
        }

        fun test() {
            reference.get()?.let {
                it.startActivity(Intent(it, MyProcessActivity::class.java))
            }
            beforeClick {
//                reference.get()?.showLoading()
                reference.get()?.showEmpty()
                Toast.makeText(DemoApplication.APP, "登陆成功开始自己的业务", Toast.LENGTH_LONG).show()
            }
        }

        fun toDownLoad() {
            reference.get()?.let {
                it.startActivity(Intent(it, DownLoadActivity::class.java))
            }
        }

        fun toList() {
            reference.get()?.let {
                it.startActivity(Intent(it, ListActivity::class.java))
            }
        }

        override fun beforeClick(block: () -> Unit) {
            //可以判断是否登陆等操作
            var isLogin = true
            if (isLogin) {
                block()
            } else {
                Toast.makeText(DemoApplication.APP, "你还没有登陆", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onRetryBtnClick() {
        showLoading()
        dataBinding.et.postDelayed({
            showError()
        }, 5000)
    }

    override fun doAfterOnCreate() {
        viewModel.getData()
        dataBinding.et.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                println("=============> ${viewModel.msg2.get()}")
                if (TextUtils.equals(s, "1")) {
                    throw NullPointerException("我是故意的")
                }
            }

        })
        startTime = System.currentTimeMillis()
//        viewModel.viewModelScope.launch {
//            test()
//        }
        //设置点击响应事件
        dataBinding.click = ClickProxy(this)
    }
}