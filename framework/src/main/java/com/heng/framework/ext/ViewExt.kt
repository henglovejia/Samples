package com.heng.framework.ext

import android.view.View
import androidx.annotation.IdRes
import com.heng.framework.base.BaseExt

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe View的扩展函数
 */

object ViewExt : BaseExt() {
    /**
     * 懒加载查找View
     */
    @JvmStatic
    fun <T : View> View.findViewLazy(@IdRes resId: Int): Lazy<T?> = lazy {
        val view = findViewById(resId) as? T
        if (view == null) {
            "find view failure from view:${this::class.java.simpleName}".logE(
                this@ViewExt.TAG
            )
        }
        view
    }
}