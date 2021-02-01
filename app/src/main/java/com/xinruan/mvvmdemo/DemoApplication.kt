package com.xinruan.mvvmdemo

import android.app.Activity
import com.xinruan.mvvmbase.BaseApplication
import com.xinruan.mvvmdemo.ui.actitivty.MainActivity
import com.xinruan.mvvmdemo.ui.actitivty.error.ErrorActivity

class DemoApplication : BaseApplication() {
    companion object {
        var APP: DemoApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        APP = this;
    }

    override fun getRestartActivity(): Class<out Activity> {
        return MainActivity::class.java
    }

    override fun getErrorActivity(): Class<out Activity> = ErrorActivity::class.java
}