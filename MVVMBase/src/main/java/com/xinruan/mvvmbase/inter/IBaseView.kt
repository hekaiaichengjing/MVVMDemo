package com.xinruan.mvvmbase.inter

interface IBaseView {
    fun showContent()
    fun showLoading()
    fun showError()
    fun showEmpty()
    fun onRefreshEmpty()
    fun onRefreshFailure(msg: String)
}