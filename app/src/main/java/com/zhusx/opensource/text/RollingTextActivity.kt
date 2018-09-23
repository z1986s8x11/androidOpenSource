package com.zhusx.opensource.text

import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AccelerateDecelerateInterpolator
import com.yy.mobile.rollingtextview.CharOrder
import com.yy.mobile.rollingtextview.strategy.Strategy
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_rolling_textview.*
import java.util.*


/**
 * https://github.com/YvesCheung/RollingText
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/9/23 11:30
 */
class RollingTextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rolling_textview)
        rollingView.animationDuration = 2000L
        rollingView.charStrategy = Strategy.NormalAnimation()
        rollingView.addCharOrder(CharOrder.Alphabet)
        rollingView.animationInterpolator = AccelerateDecelerateInterpolator()
        rollingView.addAnimatorListener(object : AnimatorListenerAdapter() {
            //TODO
        })
        tv_start.setOnClickListener {
            rollingView.setText("${Random().nextInt(10000)}")
        }
        rollingView.setText("i am a text")
    }
}