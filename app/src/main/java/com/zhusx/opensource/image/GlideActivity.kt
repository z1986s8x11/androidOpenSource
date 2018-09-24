package com.zhusx.opensource.image

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_gilde.*

/**
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/9/23 22:24
 */
class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        Glide.with(this).load("")
                .apply(RequestOptions.circleCropTransform()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true))
                .into(iv_image)
    }
}