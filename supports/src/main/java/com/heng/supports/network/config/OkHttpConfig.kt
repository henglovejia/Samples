package com.heng.supports.network.config

import com.heng.supports.config.TIME_1_SEC
import okhttp3.Interceptor

/**
 * @author zhangheng
 * @since 2020/9/26
 * @email 932805400@qq.com
 * @describe OKHttp3 参数配置类
 */
data class OkHttpConfig(
    var mConnectionTimeout: Long = 6 * TIME_1_SEC,
    var mReadTimeout: Long = 6 * TIME_1_SEC,
    var mWriteTimeout: Long = 6 * TIME_1_SEC,
    val mInterceptors: MutableList<Interceptor> = arrayListOf(),
    val mNetworkInterceptors: MutableList<Interceptor> = arrayListOf()
)