package com.zhusx.opensource.selector

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_wave_sidebar.*

/**
 * https://github.com/gjiazhe/WaveSideBar
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/9/23 0:45
 */
class WaveSideBarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wave_sidebar)
        side_bar.setOnSelectIndexItemListener {

        }
    }
}