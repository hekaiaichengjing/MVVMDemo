package com.xinruan.mvvmbase.inter

interface IBaseView {
    fun showContent()
    fun showLoading()
    fun onRefreshEmpty()
    fun onRefreshFailure(msg: String)
}