package com.zhusx.opensource.list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.scwang.smartrefresh.header.*
import com.zhusx.core.adapter._BaseRecyclerAdapter
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_smart_refresh_layout.*
import java.util.*


class SmartRefreshLayoutActivity : AppCompatActivity() {
    private lateinit var adapter: _BaseRecyclerAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_refresh_layout)
        when (Random().nextInt(12)) {
            0 -> {
                smartRefreshLayout.setRefreshHeader(MaterialHeader(this).setShowBezierWave(true))
            }
            1 -> {
                smartRefreshLayout.setRefreshHeader(BezierCircleHeader(this))
            }
            2 -> {
                smartRefreshLayout.setRefreshHeader(DeliveryHeader(this))
            }
            3 -> {
                smartRefreshLayout.setRefreshHeader(DropboxHeader(this))
            }
            4 -> {
                smartRefreshLayout.setRefreshHeader(PhoenixHeader(this))
            }
            5 -> {
                smartRefreshLayout.setRefreshHeader(FlyRefreshHeader(this))
            }
            6 -> {
                smartRefreshLayout.setRefreshHeader(FunGameBattleCityHeader(this))
            }
            7 -> {
                smartRefreshLayout.setRefreshHeader(FunGameHitBlockHeader(this))
            }
            8 -> {
                smartRefreshLayout.setRefreshHeader(WaveSwipeHeader(this))
            }
            9 -> {
                smartRefreshLayout.setRefreshHeader(TaurusHeader(this))
            }
            10 -> {
                smartRefreshLayout.setRefreshHeader(StoreHouseHeader(this))
            }
            11 -> {
                smartRefreshLayout.setRefreshHeader(WaterDropHeader(this))
            }
        }
//        smartRefreshLayout.setOnRefreshListener { it ->
//        }
//        smartRefreshLayout.setOnLoadMoreListener { it ->
//        }
        adapter = object : _BaseRecyclerAdapter<String>((0..50).map { "$it" }.toMutableList()) {
            override fun getLayoutResource(p0: Int): Int = android.R.layout.simple_list_item_1

            override fun bindViewHolder(holder: _ViewHolder, p1: Int, s: String) {
                holder.setText(android.R.id.text1, s)
            }

        }
        recyclerView.adapter = adapter
    }
}