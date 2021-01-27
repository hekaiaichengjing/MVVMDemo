package com.xinruan.mvvmdemo.ui.net

import com.xinruan.mvvmdemo.BuildConfig
import com.xinruan.netbase_api.ApiBase
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class MyApi : ApiBase {
    constructor() {
        isdebug = BuildConfig.DEBUG
    }

    override fun okClientExtreParams(builder: OkHttpClient.Builder) {

    }

    override fun retrofitExtreParams(builder: Retrofit.Builder) {

    }

    override fun getBaseUrl(): String {
        return "http://baike.idu.com"
    }
}