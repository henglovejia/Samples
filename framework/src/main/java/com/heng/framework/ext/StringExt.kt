package com.heng.framework.ext

import android.util.Log
import com.google.gson.Gson
import org.json.JSONObject

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe String 扩展函数
 */

/**
 * Log打印扩展
 */
fun String.logV(tag: String) {
    Log.v(tag, this)
}

fun String.logD(tag: String) {
    Log.d(tag, this)
}

fun String.logI(tag: String) {
    Log.i(tag, this)
}

fun String.logW(tag: String) {
    Log.w(tag, this)
}

fun String.logE(tag: String) {
    Log.e(tag, this)
}

/**
 * 解析Json字符串
 */

fun String.getJsonString(
    key: String,
    default: String?,
    errorTag: String = "StringExt#getJsonString"
) = try {
        Gson().toJson(this, String::class.java)
        JSONObject(this).getString(key)
    } catch (ex: Exception) {
        ex.toString().logE(errorTag)
        default
    }

fun String.getJsonStringOrNull(key: String) =
    getJsonString(key, null, "StringExt#getJsonStringOrNull")
