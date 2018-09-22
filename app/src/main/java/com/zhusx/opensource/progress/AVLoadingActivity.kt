package com.zhusx.opensource.progress

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wang.avi.AVLoadingIndicatorView
import com.zhusx.core.adapter._BaseRecyclerAdapter
import com.zhusx.core.utils._Toast
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_avloading.*
import java.util.*

/**
 * https://github.com/81813780/AVLoadingIndicatorView
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/9/22 10:25
 */

class AVLoadingActivity : AppCompatActivity() {
    val random = Random()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avloading)
        recyclerView.adapter = object : _BaseRecyclerAdapter<String>(INDICATORS.asList()) {
            override fun getLayoutResource(p0: Int): Int = R.layout.item_avloading

            override fun bindViewHolder(holder: _ViewHolder, p1: Int, s: String) {
                holder.getView<AVLoadingIndicatorView>(R.id.indicator).setIndicatorColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)))
                holder.getView<AVLoadingIndicatorView>(R.id.indicator).setIndicator(s)
                holder.rootView.setOnClickListener {
                    _Toast._show(s)
                }
            }
        }
    }

    private val INDICATORS = arrayOf("BallPulseIndicator",
            "BallGridPulseIndicator",
            "BallClipRotateIndicator",
            "BallClipRotatePulseIndicator",
            "SquareSpinIndicator",
            "BallClipRotateMultipleIndicator",
            "BallPulseRiseIndicator",
            "BallRotateIndicator",
            "CubeTransitionIndicator",
            "BallZigZagIndicator",
            "BallZigZagDeflectIndicator",
            "BallTrianglePathIndicator",
            "BallScaleIndicator",
            "LineScaleIndicator",
            "LineScalePartyIndicator",
            "BallScaleMultipleIndicator",
            "BallPulseSyncIndicator",
            "BallBeatIndicator",
            "LineScalePulseOutIndicator",
            "LineScalePulseOutRapidIndicator",
            "BallScaleRippleIndicator",
            "BallScaleRippleMultipleIndicator",
            "BallSpinFadeLoaderIndicator",
            "LineSpinFadeLoaderIndicator",
            "TriangleSkewSpinIndicator",
            "PacmanIndicator",
            "BallGridBeatIndicator",
            "SemiCircleSpinIndicator")
}