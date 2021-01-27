package com.xinruan.netbase_api

interface ResultState<T> {
    fun loadedSuc(requestId: Int, t: T)
    fun loadedFail(requestId: Int, throwable: Throwable)
}