package com.xinruan.mvvmdemo

import com.xinruan.mvvmbase.BaseApplication

class DemoApplication : BaseApplication() {
    companion object {
        var APP: DemoApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        APP = this;
    }
}