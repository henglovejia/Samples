package com.heng.framework.card

import androidx.annotation.LayoutRes

/**
 * @author zhangheng
 * @since 2020/10/4
 * @email 932805400@qq.com
 * @describe 卡片基础属性
 */
data class CardFields<T : BaseCardData, R : BaseCardVH>(
    val item: T,                    // 卡片数据
    @LayoutRes val layoutId: Int,   // 卡片布局
    val viewType: Int,              // 卡片类型
    val viewHolder: R,              // 卡片VH
    val describe: String            // 卡片描述
)