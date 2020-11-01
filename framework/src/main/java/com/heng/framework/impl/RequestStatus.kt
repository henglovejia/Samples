package com.heng.framework.impl

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe 网络请求状态接口
 */
interface RequestStatus {
    // 请求数据
    fun RequestData()

    // 请求成功(有数据)
    fun RequestSuccess()

    // 请求成功(空数据)
    fun RequestEmpty()

    // 请求失败(超时、请求取消等情况)
    fun RequestFailure()
}