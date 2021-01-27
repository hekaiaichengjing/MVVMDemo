package com.xinruan.mvvmbase.vm

interface IBaseModelLisnter {
    fun loadSuc(requestId: Int, any: Any)
    fun netFailed()
}