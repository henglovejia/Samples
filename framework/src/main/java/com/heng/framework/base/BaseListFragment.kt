package com.heng.framework.base

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heng.framework.card.BaseAdapter
import com.heng.framework.card.BaseCardData
import com.heng.framework.card.BaseCardVH
import com.heng.framework.ext.ViewExt.findView

/**
 * @author zhangheng
 * @since 2020/10/4
 * @email 932805400@qq.com
 * @describe 列表Fragment基类
 * 1. 该类仅设置基础属性(layoutManager和adapter)
 */
abstract class BaseListFragment : BaseFragment() {
    protected var mRecycleView: RecyclerView? = null

    /**
     * 获取RecycleView的ID
     */
    abstract fun getRecycleViewId(): Int

    /**
     * 获取适配器
     */
    abstract fun getAdapter(): BaseAdapter

    /**
     * 获取布局管理器
     * 默认线性布局
     */
    open fun getLayoutManager() = LinearLayoutManager(this.context)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecycleView = view.findView(getRecycleViewId())
        mRecycleView?.layoutManager = getLayoutManager()
        mRecycleView?.adapter = getAdapter()
    }
}