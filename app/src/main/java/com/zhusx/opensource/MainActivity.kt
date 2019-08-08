package com.zhusx.opensource

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhusx.core.adapter._BaseRecyclerAdapter
import com.zhusx.core.adapter._ViewHolder
import com.zhusx.core.debug.LogUtil
import com.zhusx.opensource.camera.MatisseActivity
import com.zhusx.opensource.camera.PictureSelectorActivity
import com.zhusx.opensource.camera.ZXingActivity
import com.zhusx.opensource.desc.KotlinAnkoActivity
import com.zhusx.opensource.image.FrescoPhotoViewActivity
import com.zhusx.opensource.image.GlideActivity
import com.zhusx.opensource.image.PhotoViewActivity
import com.zhusx.opensource.list.FlexboxLayoutActivity
import com.zhusx.opensource.list.LRecyclerViewActivity
import com.zhusx.opensource.list.SmartRefreshLayoutActivity
import com.zhusx.opensource.progress.AVLoadingActivity
import com.zhusx.opensource.progress.WhiteProgressViewActivity
import com.zhusx.opensource.selector.*
import com.zhusx.opensource.text.RollingTextActivity
import com.zhusx.opensource.text.TickerActivity
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
        recyclerView.adapter = object : _BaseRecyclerAdapter<Class<out AppCompatActivity>>(R.layout.lib_list_item_1,
                arrayListOf(
                        FrescoPhotoViewActivity::class.java,
                        PhotoViewActivity::class.java,
                        LRecyclerViewActivity::class.java,
                        AVLoadingActivity::class.java,
                        PictureSelectorActivity::class.java,
                        MatisseActivity::class.java,
                        BannerDotActivity::class.java,
                        DiscreteSeekBarActivity::class.java,
                        WaveSideBarActivity::class.java,
                        ZXingActivity::class.java,
                        RollingTextActivity::class.java,
                        PatternLockerActivity::class.java,
                        GlideActivity::class.java,
                        MagicIndicatorActivity::class.java,
                        SmartRefreshLayoutActivity::class.java,
                        KotlinAnkoActivity::class.java,
                        FlexboxLayoutActivity::class.java,
                        TickerActivity::class.java,
                        CalendarViewActivity::class.java,
                        WhiteProgressViewActivity::class.java
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
        lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onCreate(owner: LifecycleOwner) {
                LogUtil.e("onCreate:$owner   status:${lifecycle.currentState}")
            }

            override fun onDestroy(owner: LifecycleOwner) {
                LogUtil.e("onDestroy:$owner   status:${lifecycle.currentState}")
            }

            override fun onPause(owner: LifecycleOwner) {
                LogUtil.e("onPause:$owner   status:${lifecycle.currentState}")
            }

            override fun onResume(owner: LifecycleOwner) {
                LogUtil.e("onResume:$owner   status:${lifecycle.currentState}")
            }

            override fun onStart(owner: LifecycleOwner) {
                LogUtil.e("onStart:$owner   status:${lifecycle.currentState}")
            }

            override fun onStop(owner: LifecycleOwner) {
                LogUtil.e("onStop:$owner   status:${lifecycle.currentState}")
            }
        })
    }
}