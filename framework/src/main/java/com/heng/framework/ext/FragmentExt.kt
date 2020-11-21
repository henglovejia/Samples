package com.heng.framework.ext

import android.view.View
import androidx.annotation.IdRes
import com.heng.framework.base.BaseFragment

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe
 */
fun <T : View> BaseFragment.findViewLazy(@IdRes resId: Int): Lazy<T?> = lazy {
    View(this.context) as? T
}