package com.xinruan.netbase_api

import com.google.gson.GsonBuilder
import com.xinruan.netbase_api.constants.NetConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class ApiBase {
    var isdebug: Boolean = false
    private val retrofit: Retrofit by lazy {
        val builder = Retrofit.Builder()
            .client(okHttpClient.value)
            .baseUrl(getBaseUrl())
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().create())
            )
        retrofitExtreParams(builder)
        builder.build()
    }

    //    private val sErrorTransformer = ""
    private val okHttpClient: Lazy<OkHttpClient> = lazy {
        val builder = OkHttpClient.Builder()
            .connectTimeout(NetConstants.CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NetConstants.READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NetConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)
        setLoggingLevel(builder)
        okClientExtreParams(builder)
        builder.build()
    }

    /**
     * 实现该方法 可以对okhttp添加想要的功能
     */
    abstract fun okClientExtreParams(builder: OkHttpClient.Builder)

    /**
     * 实现该方法 可以对Retrofit添加想要的功能
     */
    abstract fun retrofitExtreParams(builder: Retrofit.Builder)

    /**
     * 设置baseUrl
     */
    abstract fun getBaseUrl(): String

    private fun setLoggingLevel(builder: OkHttpClient.Builder) {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isdebug) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        builder.addInterceptor(logging)
    }

    fun <T> getApi(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}