package com.zhusx.opensource.image

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.zhusx.opensource.R
import com.zhusx.opensource.TestData
import kotlinx.android.synthetic.main.activity_gilde.*

/**
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/8/16 15:28
 */
class PhotoViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photoview_glide)
        Glide.with(this).load(TestData.Images[0]).into(iv_image)
    }
}