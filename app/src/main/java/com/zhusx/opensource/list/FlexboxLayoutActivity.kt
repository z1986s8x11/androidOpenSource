package com.zhusx.opensource.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import com.google.android.flexbox.*
import com.zhusx.core.adapter._BaseRecyclerAdapter
import com.zhusx.core.adapter._ViewHolder
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_main.*

class FlexboxLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flexbox)
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexWrap = FlexWrap.WRAP
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.alignItems = AlignItems.STRETCH
        layoutManager.justifyContent = JustifyContent.FLEX_START
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = object : _BaseRecyclerAdapter<String>(R.layout.lib_grid_item, (0..100).map { "$it" }.toList()) {
            override fun bindViewHolder(holder: _ViewHolder, p1: Int, p2: String?) {
                holder.setText(android.R.id.text1, p2)
                val lp = holder.itemView?.layoutParams
                if (lp is FlexboxLayoutManager.LayoutParams) {
                    lp.flexGrow = 1.0f
                }
            }
        }
    }
}