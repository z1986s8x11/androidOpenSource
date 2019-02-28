package com.zhusx.opensource.progress

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_white_progress.*

/**
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2019/2/28 10:53
 */
class WhiteProgressViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_white_progress)
        circle_progress_normal.setProgressInTime(0,68, 2500)
    }
}