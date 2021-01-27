package com.xinruan.mvvmdemo.ui.net

import com.xinruan.netbase_api.respance.BaseResponse
import retrofit2.http.GET

interface MyInterface {
    /**
     * 测试
     */
    @GET("/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%93%B6%E9%AD%82&bk_length=600")
    suspend fun test(): BaseResponse
}