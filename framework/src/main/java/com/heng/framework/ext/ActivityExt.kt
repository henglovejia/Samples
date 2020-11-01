package com.heng.framework.ext

import android.view.View
import com.heng.framework.base.BaseActivity

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe
 */

/**
 * 懒加载查找View
 */
const val TAG = "ActivityExt"
inline fun <reified T : View> BaseActivity.findViewLazy(resId: Int): Lazy<T?> = lazy {
    val view = findViewById(resId) as? T
    if (view == null) {
        "find view failure, activity is:${this.TAG} and view is:${T::class.java.simpleName}".logE(
            TAG
        )
    }
    view
}