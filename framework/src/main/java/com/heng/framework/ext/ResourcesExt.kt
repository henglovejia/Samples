package com.heng.framework.ext

import android.content.res.XmlResourceParser
import androidx.annotation.IntDef
import com.heng.framework.base.BaseActivity
import java.lang.reflect.Type

/**
 * @author zhangheng
 * @since 2020/11/1
 * @email 932805400@qq.com
 * @describe 资源扩展函数
 */

/**
 * 扩展函数中支持获取的类型
 */

const val INT = 0
const val INT_ARRAY = 1
const val STRING = 2
const val STRING_ARRAY = 3
const val TEXT = 4
const val BOOLEAN = 5
const val ANIMATION = 6
const val DIMEN = 7

@IntDef(INT, INT_ARRAY, STRING, STRING_ARRAY, TEXT, BOOLEAN, ANIMATION, DIMEN)
@Retention(AnnotationRetention.SOURCE)
annotation class SupportResourceType

/**
 * 懒加载获取资源
 * 能获取的资源种类请参考[SupportResourceType]
 */
fun <T> BaseActivity.getResourceLazy(resId: Int, returnType: Type): Lazy<T?> = lazy {
    val resource = when (returnType.javaClass) {
        Int::class.java -> {
            resources.getInteger(resId) as? T
        }
        IntArray::class.java -> {
            resources.getIntArray(resId) as? T
        }
        String::class.java -> {
            resources.getString(resId) as? T
        }
        Array<String>::class.java -> {
            resources.getStringArray(resId) as? T
        }
        CharSequence::class.java -> {
            resources.getText(resId) as? T
        }
        Boolean::class.java -> {
            resources.getBoolean(resId) as? T
        }
        XmlResourceParser::class.java -> {
            resources.getAnimation(resId) as? T
        }
        Float::class.java -> {
            resources.getDimension(resId) as? T
        }
        else -> {
            null
        }
    }
    if (resource == null) {
        "the resource type is not support".logE("ResourceExt")
    }
    resource
}