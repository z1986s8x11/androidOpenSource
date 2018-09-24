package com.zhusx.opensource.image

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.zhusx.core.utils._Views
import com.zhusx.opensource.R
import com.zhusx.opensource.TestData
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
        setContentView(R.layout.activity_gilde)
        Glide.with(this).load(TestData.Images[0])
                .apply(RequestOptions.circleCropTransform()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true))
                .into(iv_image)

        Glide.with(this).load(TestData.Images[0])
                .apply(RequestOptions.bitmapTransform(RoundedCorners(_Views.dip2px(10f)))
                        .override(300, 300))
                .into(iv_image1)
    }
}