package com.heng.samples

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.alibaba.android.arouter.launcher.ARouter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.heng.framework.base.BaseActivity
import com.heng.framework.ext.ActivityExt.findViewLazy
import com.heng.framework.ext.ResourcesExt.getResourceLazy
import com.heng.framework.ext.SupportResourceType
import com.heng.framework.ext.logE

/**
 * @author zhangheng
 * @since 2020/10/4
 * @email 932805400@qq.com
 * @describe 主入口
 */
class MainActivity : BaseActivity() {
    private val mViewPager by findViewLazy<ViewPager2>(R.id.main_view_pager2)
    private val mTabLayout by findViewLazy<TabLayout>(R.id.main_tab_layout)
    private val mTabPath by getResourceLazy<Array<String>>(
        R.array.main_tabs_path,
        SupportResourceType.STRING_ARRAY
    )
    private val mAdapter: FragmentStateAdapter by lazy { getViewPager2Adapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        mViewPager?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        mViewPager?.adapter = mAdapter
        mediator()
    }

    private fun getViewPager2Adapter(): FragmentStateAdapter {
        return object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return mTabPath?.size ?: 0
            }

            override fun createFragment(position: Int): Fragment {
                val path = mTabPath?.getOrNull(position)
                val fragment = ARouter.getInstance().build(path).navigation() as? Fragment
                return fragment ?: Fragment()
            }
        }
    }

    // 关联ViewPager2与TabLayout
    private fun mediator() {
        if (mTabLayout != null && mViewPager != null) {
            TabLayoutMediator(mTabLayout!!, mViewPager!!, true) { tab, position ->
                tab.text = "$position"
            }.attach()
        } else {
            "mediator failed, because tab layout is null:${mTabLayout == null} or view pager2 is null:${mViewPager == null}".logE(
                TAG
            )
        }
    }
}