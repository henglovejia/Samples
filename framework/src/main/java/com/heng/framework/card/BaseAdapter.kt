package com.heng.framework.card

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author zhangheng
 * @since 2020/10/4
 * @email 932805400@qq.com
 * @describe Adapter基类
 */
open class BaseAdapter : RecyclerView.Adapter<BaseCardVH>() {
    protected val mData: MutableList<CardFields<BaseCardData, BaseCardVH>> = arrayListOf()

    fun setData(data: MutableList<CardFields<BaseCardData, BaseCardVH>>?) {
        mData.clear()
        data?.let { mData.addAll(it) }
    }

    /**
     * 末尾添加一个数据
     */
    fun addData(data: CardFields<BaseCardData, BaseCardVH>?) {
        data?.let { addData(mData.size, data) }
    }

    /**
     * 指定位置添加一个数据
     */
    fun addData(index: Int, data: CardFields<BaseCardData, BaseCardVH>?) {
        data?.let { mData.add(index, it) }
    }

    /**
     * 末尾添加一组数据
     */
    fun addData(data: MutableList<CardFields<BaseCardData, BaseCardVH>>?) {
        data?.let { addData(mData.size, it) }
    }

    /**
     * 指定位置添加一组数据
     */
    fun addData(index: Int, data: MutableList<CardFields<BaseCardData, BaseCardVH>>?) {
        data?.let { mData.addAll(index, it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseCardVH {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BaseCardVH, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = mData.size
}