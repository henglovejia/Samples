package com.heng.framework.ext

import android.view.View
import androidx.annotation.IdRes
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
fun <T : View> BaseActivity.findViewLazy(@IdRes resId: Int): Lazy<T?> = lazy {
    val view = findViewById(resId) as? T
    if (view == null) {
        "find view failure from activity:${this.TAG}".logE("ActivityExt")
    }
    view
}