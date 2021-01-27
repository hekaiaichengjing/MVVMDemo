package com.xinruan.mvvmdemo.ui.net

private val INSTANCE: MyApi by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    MyApi()
}
val myInterface: MyInterface by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
    INSTANCE.getApi(MyInterface::class.java)
}