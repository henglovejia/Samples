package com.heng.framework.card

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * @author zhangheng
 * @since 2020/10/4
 * @email 932805400@qq.com
 * @describe Adapter基类
 */
class BaseAdapter<T : BaseCardData, R : BaseCardVH> : RecyclerView.Adapter<R>() {
    val mData: MutableList<CardFields<T, R>> = arrayListOf()

    public fun setData(data: MutableList<CardFields<T, R>>?) {
        mData.clear()
        data?.let { mData.addAll(it) }
    }

    // 末尾添加一个数据
    public fun addData(data: CardFields<T, R>?) {
        data?.let { addData(mData.size, data) }
    }

    // 指定位置添加一个数据
    public fun addData(index: Int, data: CardFields<T, R>?) {
        data?.let { mData.add(index, it) }
    }

    // 末尾添加一组数据
    public fun addData(data: MutableList<CardFields<T, R>>?) {
        data?.let { addData(mData.size, it) }
    }

    // 指定位置添加一组数据
    public fun addData(index: Int, data: MutableList<CardFields<T, R>>?) {
        data?.let { mData.addAll(index, it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): R {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: R, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = mData.size
}