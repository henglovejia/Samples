package com.heng.framework.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @author zhangheng
 * @since 2020/10/4
 * @email 932805400@qq.com
 * @describe Fragment基类
 * 1.初始化布局
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    /**
     * 获取布局ID
     */
    abstract fun getLayoutId(): Int
}