package com.zhusx.opensource.selector

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zhusx.core.adapter._BasePagerAdapter
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_banner_dot.*

/**
 * https://github.com/yanyiqun001/bannerDot
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/9/22 16:50
 */
class BannerDotActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner_dot)
        viewPager.adapter = object : _BasePagerAdapter<String>(R.layout.lib_list_item_1, arrayOf("1", "2", "3", "4", "5", "6", "7", "8").toList()) {
            override fun bindViewHolder(holder: _ViewsHolder, p1: Int, s: String?) {
                holder.getView<TextView>(android.R.id.text1).text = s
            }
        }
        banner.attachToViewpager(viewPager)
    }
}