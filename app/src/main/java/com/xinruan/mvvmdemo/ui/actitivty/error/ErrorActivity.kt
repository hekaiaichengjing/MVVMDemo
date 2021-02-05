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

    private val COUNT_DOWN = 90
    private var nowCount = 0

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

        countCheck()

    }

    override fun getRealViewModel(): ErrorActivityViewModel =
        ViewModelProvider(this).get(ErrorActivityViewModel::class.java)

    override fun getDBVariableId(): Int {




        return BR.err_vm
    }


    fun reStartApp() {
        println("-----------------> ${config}")
        config?.let {
            CustomActivityOnCrash.restartApplication(this, it)
        }
    }


    private fun countCheck() {

        if (!isFinishing && dataBinding.root != null) {
            if (nowCount > COUNT_DOWN) {
                //触发跳转
                reStartApp()
                return
            }

            var countLeft =
                String.format(
                    getString(R.string.error_occurred),
                    (COUNT_DOWN - nowCount).toString()
                )
            viewModel.count_msg.set(countLeft)
            dataBinding.root.postDelayed({
                nowCount++
                countCheck()
            }, 1000)
        }
    }

    override fun doAfterOnCreate() {

    }

}

