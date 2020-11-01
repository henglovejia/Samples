package com.heng.framework.ext

import androidx.annotation.IdRes
import com.heng.framework.base.BaseActivity
import com.heng.framework.base.BaseExt

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe 资源扩展函数
 */

/**
 * 扩展函数中支持获取的类型
 */
enum class SupportResourceType {
    INT, INT_ARRAY, STRING, STRING_ARRAY, TEXT, BOOLEAN, ANIMATION, DIMEN
}

object ResourcesExt : BaseExt() {
    /**
     * 懒加载获取资源
     * 能获取的资源种类请参考[SupportResourceType]
     */
    @JvmStatic
    fun <T> BaseActivity.getResourceLazy(resId: Int, type: SupportResourceType): Lazy<T?> = lazy {
        val resource = when (type) {
            SupportResourceType.INT -> {
                resources.getInteger(resId)
            }
            SupportResourceType.INT_ARRAY -> {
                resources.getIntArray(resId)
            }
            SupportResourceType.STRING -> {
                resources.getString(resId)
            }
            SupportResourceType.STRING_ARRAY -> {
                resources.getStringArray(resId)
            }
            SupportResourceType.TEXT -> {
                resources.getText(resId)
            }
            SupportResourceType.BOOLEAN -> {
                resources.getBoolean(resId)
            }
            SupportResourceType.ANIMATION -> {
                resources.getAnimation(resId)
            }
            SupportResourceType.DIMEN -> {
                resources.getDimension(resId)
            }
            else -> {
                null
            }
        }
        if (resource != null) {
            "the type of resource is:${resource::class.java.simpleName}".logD(this@ResourcesExt.TAG)
        } else {
            "get resource failure".logE("ResourcesExt")
        }
        resource as? T
    }
}