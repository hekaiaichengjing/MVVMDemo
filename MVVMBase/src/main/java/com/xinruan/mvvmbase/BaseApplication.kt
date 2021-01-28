package com.xinruan.mvvmbase

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

open class BaseApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

    }
}