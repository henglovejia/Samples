package com.heng.samples

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.heng.framework.base.BaseActivity
import com.heng.framework.ext.findViewLazy
import com.heng.framework.ext.logD

/**
 * @author zhangheng
 * @since 2020/10/4
 * @email 932805400@qq.com
 * @describe 主入口
 */
class MainActivity : BaseActivity() {
    private val mViewPager2 by findViewLazy<ViewPager2>(R.id.main_view_pager2)
    private val mTabLayout by findViewLazy<TabLayout>(R.id.main_tab_layout)
    private val mAdapter: FragmentStateAdapter by lazy { getViewPager2Adapter() }
    private val mTabPath by lazy { resources.getStringArray(R.array.main_tabs_path) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        "onCreate start".logD(TAG)
    }

    override fun onStart() {
        super.onStart()
        mViewPager2?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mViewPager2?.adapter = mAdapter
        mediator()
    }

    private fun getViewPager2Adapter(): FragmentStateAdapter {
        return object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return mTabPath.size
            }

            override fun createFragment(position: Int): Fragment {
                val path = mTabPath[position]
                val fragment = ARouter.getInstance().build(path).navigation() as? Fragment
                return fragment ?: Fragment()
            }
        }
    }

    // 关联ViewPager2与TabLayout
    private fun mediator() {
        if (mTabLayout != null && mViewPager2 != null) {
            TabLayoutMediator(mTabLayout!!, mViewPager2!!, true,
                TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                    tab.text = "$position"
                }).attach()
        } else {
            Log.d(
                TAG,
                "mediator failed, because tab layout is null:${mTabLayout == null} or view pager2 is null:${mViewPager2 == null}"
            )
        }
    }
}