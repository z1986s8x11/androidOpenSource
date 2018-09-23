package com.zhusx.opensource

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhusx.core.imp.SimpleRecyclerAdapter
import com.zhusx.opensource.camera.PictureSelectorActivity
import com.zhusx.opensource.camera.ZXingActivity
import com.zhusx.opensource.image.FrescoPhotoViewActivity
import com.zhusx.opensource.image.PhotoViewActivity
import com.zhusx.opensource.list.LRecyclerViewActivity
import com.zhusx.opensource.progress.AVLoadingActivity
import com.zhusx.opensource.selector.BannerDotActivity
import com.zhusx.opensource.selector.DiscreteSeekBarActivity
import com.zhusx.opensource.selector.WaveSideBarActivity
import com.zhusx.opensource.text.RollingTextActivity
import com.zhusx.opensource.verify.PatternLockerActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/8/16 15:32
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = object : SimpleRecyclerAdapter<Class<out AppCompatActivity>>(R.layout.lib_list_item_1,
                arrayListOf(
                        FrescoPhotoViewActivity::class.java,
                        PhotoViewActivity::class.java,
                        LRecyclerViewActivity::class.java,
                        AVLoadingActivity::class.java,
                        PictureSelectorActivity::class.java,
                        BannerDotActivity::class.java,
                        DiscreteSeekBarActivity::class.java,
                        WaveSideBarActivity::class.java,
                        ZXingActivity::class.java,
                        RollingTextActivity::class.java,
                        PatternLockerActivity::class.java

                )) {
            override fun bindViewHolder(holder: _ViewHolder, p1: Int, s: Class<out AppCompatActivity>) {
                holder.run {
                    setText(android.R.id.text1, s.simpleName)
                    rootView.setOnClickListener {
                        startActivity(Intent(it.context, s))
                    }
                }
            }
        }
    }
}