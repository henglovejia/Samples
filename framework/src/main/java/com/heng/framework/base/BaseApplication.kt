package com.heng.framework.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.heng.framework.BuildConfig

/**
 * @author zhangheng
 * @since 2020/10/31
 * @email 932805400@qq.com
 * @describe Application基类
 * 1. 开启ARouter
 * 2.
 */
open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        ARouter.getInstance().destroy()
    }
}