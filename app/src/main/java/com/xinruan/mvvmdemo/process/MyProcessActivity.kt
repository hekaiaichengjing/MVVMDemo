package com.xinruan.mvvmdemo.process

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.xinruan.mvvmdemo.R
import java.lang.NullPointerException

class MyProcessActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myprocess)
        Handler(Looper.getMainLooper()).postDelayed({
                                                    throw NullPointerException("我是故意的")
        }, 5000)
    }


}