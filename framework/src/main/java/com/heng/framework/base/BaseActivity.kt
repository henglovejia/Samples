package com.heng.framework.base

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author zhangheng
 * @since 2020/10/4
 * @email 932805400@qq.com
 * @describe Activity基类
 * 1.路由注册
 */
open class BaseActivity : AppCompatActivity() {
    val TAG = this::class.java.simpleName

    // 是否打印生命周期
    protected var DEBUG = false

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ARouter.getInstance().inject(this)
        if (DEBUG) {
            Log.d(TAG, "onCreate")
        }
    }

    override fun onStart() {
        super.onStart()
        if (DEBUG) {
            Log.d(TAG, "onStart")
        }
    }

    override fun onResume() {
        super.onResume()
        if (DEBUG) {
            Log.d(TAG, "onResume")
        }
    }

    override fun onPause() {
        super.onPause()
        if (DEBUG) {
            Log.d(TAG, "onPause")
        }
    }

    override fun onStop() {
        super.onStop()
        if (DEBUG) {
            Log.d(TAG, "onStop")
        }
    }

    override fun onRestart() {
        super.onRestart()
        if (DEBUG) {
            Log.d(TAG, "onRestart")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (DEBUG) {
            Log.d(TAG, "onDestroy")
        }
    }
}