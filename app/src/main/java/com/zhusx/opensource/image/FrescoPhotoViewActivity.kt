package com.zhusx.opensource.image

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhusx.opensource.R
import com.zhusx.opensource.TestData
import kotlinx.android.synthetic.main.activity_fresco.*

/**
 * https://github.com/ongakuer/PhotoDraweeView
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/8/16 15:28
 */
class FrescoPhotoViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fresco)
        iv_image.setPhotoUri(Uri.parse(TestData.Images[0]))
    }
}