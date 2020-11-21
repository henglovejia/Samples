package com.heng.framework.ext

import android.view.View
import androidx.annotation.IdRes

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe View的扩展函数
 */

/**
 * 懒加载查找View
 */
fun <T : View> View.findViewLazy(@IdRes resId: Int): Lazy<T?> = lazy {
    val view = findViewById(resId) as? T
    if (view == null) {
        "find view failure from view:${this::class.java.simpleName}".logE(
            "ViewExt"
        )
    }
    view
}

fun <T : View> View.findView(@IdRes resId: Int): T? {
    val view = findViewById(resId) as? T
    if (view == null) {
        "find view failure from view:${this::class.java.simpleName}".logE(
            "ViewExt"
        )
    }
    return view
}