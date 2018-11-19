package com.zhusx.opensource.text

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.robinhood.ticker.TickerUtils
import com.zhusx.opensource.R
import kotlinx.android.synthetic.main.activity_ticker.*
import java.util.*

class TickerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticker)
        tickerView.setCharacterLists(TickerUtils.provideNumberList())

        btn_commit.setOnClickListener {
            tickerView.text = "¥${Random().nextInt(10000)}"
        }
    }
}