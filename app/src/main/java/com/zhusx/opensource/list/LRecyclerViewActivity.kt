package com.zhusx.opensource.list

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.github.jdsjlzx.ItemDecoration.DividerDecoration
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter
import com.github.jdsjlzx.recyclerview.ProgressStyle
import com.zhusx.core.adapter._BaseRecyclerAdapter
import com.zhusx.core.adapter._ViewHolder
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_lrecyclerview.*


/**
 * https://github.com/jdsjlzx/LRecyclerView
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/8/16 16:11
 */
class LRecyclerViewActivity : AppCompatActivity() {
    private val handler: Handler by lazy { Handler() }
    private val runnable: Runnable = Runnable {
        recyclerView.refreshComplete(10)
    }
    lateinit var adapter: _BaseRecyclerAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lrecyclerview)
        adapter = object : _BaseRecyclerAdapter<String>(android.R.layout.simple_list_item_1, (0..10).map { "$it" }) {
            override fun bindViewHolder(holder: _ViewHolder, p1: Int, s: String?) {
                holder.setText(android.R.id.text1, s)
            }
        }
        recyclerView.adapter = object : LRecyclerViewAdapter(adapter) {
            override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
            }
        }
        //下拉刷新
        recyclerView.setOnRefreshListener {
            handler.postDelayed(runnable, 3000)
        }
        //加载更多
        recyclerView.setOnLoadMoreListener {
            handler.postDelayed(runnable, 3000)
        }
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallPulse)
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader)

        //recyclerView.setLoadMoreEnabled(false)

        val divider = DividerDecoration.Builder(this)
                .setHeight(10f)
                .setPadding(10f)
                .setColorResource(R.color.lib_bg_green)
                .build()
        recyclerView.addItemDecoration(divider)
    }
}