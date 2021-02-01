package com.xinruan.mvvmdemo.ui.actitivty.error

import androidx.lifecycle.ViewModelProvider
import cat.ereza.customactivityoncrash.CustomActivityOnCrash
import cat.ereza.customactivityoncrash.config.CaocConfig
import com.xinruan.mvvmdemo.BR
import com.xinruan.mvvmdemo.R
import com.xinruan.mvvmdemo.databinding.ActivityErrorBinding
import com.xinruan.mvvmloadsirbase.activity.BaseLoadSirActivity

class ErrorActivity :
    BaseLoadSirActivity<ActivityErrorBinding, ErrorActivityViewModel>() {
    var config: CaocConfig? = null
    override fun onRetryBtnClick() {
    }

    override fun getLayoutId(): Int = R.layout.activity_error


    override fun doOnCreate() {
        config = CustomActivityOnCrash.getConfigFromIntent(intent)
        CustomActivityOnCrash.getStackTraceFromIntent(intent)?.let {
//            val mClipData = ClipData.newPlainText("errorLog", it)
            println("-----报错--> $it")
        }
        dataBinding.click = this
    }

    override fun getRealViewModel(): ErrorActivityViewModel =
        ViewModelProvider(this).get(ErrorActivityViewModel::class.java)

    override fun getDBVariableId(): Int {
        return 0
    }

//    fun reOpen() {
//
//    }

    fun reStartApp() {
        println("-----------------> ${config}")
        config?.let {
            CustomActivityOnCrash.restartApplication(this, it)
        }
    }
}

