package com.heng.framework.network.call

import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.Type

/**
 * @author zhangheng
 * @since 2020/9/26
 * @email 932805400@qq.com
 * @describe
 */
class SampleCallAdapterFactory: CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        TODO("Not yet implemented")
    }
}