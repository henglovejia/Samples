package com.heng.framework.ext

import android.util.Log
import com.heng.framework.base.BaseExt

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

object StringExt : BaseExt() {

}