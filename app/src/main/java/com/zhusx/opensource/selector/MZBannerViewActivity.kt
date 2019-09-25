package com.zhusx.opensource.selector

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.zhouwei.mzbanner.holder.MZViewHolder
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_mzbanner.*


class MZBannerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mzbanner)
        val list = mutableListOf<Int>(R.color.lib_bg_blue, R.color.lib_bg_green, R.color.lib_bg_red, R.color.lib_brown)
        banner.setPages(list as List<Nothing>?) {
            BannerViewHolder()
        }
    }

    class BannerViewHolder : MZViewHolder<Int> {
        private var mImageView: ImageView? = null
        override fun createView(context: Context): View {
            val view = LayoutInflater.from(context).inflate(R.layout.lib_page_image, null)
            mImageView = view.findViewById(android.R.id.icon) as ImageView
            return view
        }

        override fun onBind(context: Context, position: Int, data: Int) {
            mImageView!!.setImageResource(data)
        }
    }

    public override fun onPause() {
        super.onPause()
        banner.pause()//暂停轮播
    }

    public override fun onResume() {
        super.onResume()
        banner.start()//开始轮播
    }
}