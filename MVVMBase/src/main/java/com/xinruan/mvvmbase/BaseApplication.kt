package com.xinruan.mvvmbase

import android.app.Application
import android.content.Context

open class BaseApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }

    override fun onCreate() {
        super.onCreate()

    }
}