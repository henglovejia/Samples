package com.heng.supports.network

import com.heng.framework.network.call.SampleCallAdapterFactory
import com.heng.framework.network.call.SampleCallFactory
import com.heng.framework.network.config.OkHttpConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author zhangheng
 * @since 2020/9/26
 * @email 932805400@qq.com
 * @describe 使用 lazy 初始化mDefaultOkHttpConfig、mRetrofit和mOkHttpClient
 */
object NetworkService {
    @JvmStatic
    public fun <T> getNetworkService(service: Class<T>) = mRetrofit.create(service)

    private val mRetrofit: Retrofit by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        Retrofit.Builder()
            .client(mOkHttpClient)
            .addCallAdapterFactory(SampleCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .callFactory(SampleCallFactory())
            .build()
    }

    private val mOkHttpClient: OkHttpClient by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        builder.connectTimeout(mDefaultOkHttpConfig.mConnectionTimeout, TimeUnit.MILLISECONDS)
        builder.readTimeout(mDefaultOkHttpConfig.mReadTimeout, TimeUnit.MILLISECONDS)
        builder.writeTimeout(mDefaultOkHttpConfig.mWriteTimeout, TimeUnit.MILLISECONDS)
        builder.interceptors().addAll(mDefaultOkHttpConfig.mInterceptors)
        builder.networkInterceptors().addAll(mDefaultOkHttpConfig.mNetworkInterceptors)
        builder.build()
    }

    // 默认 OkHttp3 配置参数
    private val mDefaultOkHttpConfig: OkHttpConfig by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        OkHttpConfig()
    }
}