package com.zhusx.opensource.verify

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.ihsg.patternlocker.OnPatternChangeListener
import com.github.ihsg.patternlocker.PatternLockerView
import com.zhusx.core.utils._Toast
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_pattern_locker.*

/**
 * https://github.com/ihsg/PatternLocker
 *
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/9/23 12:03
 */
class PatternLockerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pattern_locker)
        pattern_lock_view.setOnPatternChangedListener(object : OnPatternChangeListener {
            //开始绘制图案时（即手指按下触碰到绘画区域时）会调用该方法
            override fun onStart(p0: PatternLockerView?) {
            }

            //图案绘制改变时（即手指在绘画区域移动时）会调用该方法，请注意只有 @param hitList改变了才会触发此方法
            override fun onChange(p0: PatternLockerView?, hitList: MutableList<Int>?) {
            }

            //图案绘制完成时（即手指抬起离开绘画区域时）会调用该方法
            override fun onComplete(p0: PatternLockerView?, result: MutableList<Int>?) {
                _Toast._show(result.toString())
            }

            //已绘制的图案被清除时会调用该方法
            override fun onClear(p0: PatternLockerView?) {
            }
        })
    }
}
