package com.heng.framework.ext

import android.view.View
import androidx.annotation.IdRes
import com.heng.framework.base.BaseActivity
import com.heng.framework.base.BaseExt

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe
 */

object ActivityExt : BaseExt() {
    /**
     * 懒加载查找View
     */
    @JvmStatic
    fun <T : View> BaseActivity.findViewLazy(@IdRes resId: Int): Lazy<T?> = lazy {
        val view = findViewById(resId) as? T
        if (view == null) {
            "find view failure from activity:${this.TAG}".logE(this@ActivityExt.TAG)
        }
        view
    }
}