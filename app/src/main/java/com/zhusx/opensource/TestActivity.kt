package com.zhusx.opensource

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout
import org.jetbrains.anko.*

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(UI {
            verticalLayout {
                textView("测试") {
                    padding = dip(10)
                }.lparams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT) {
                    setGravity(Gravity.CENTER_HORIZONTAL)
                }
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    button("OK") {
                        setOnClickListener {
                            toast("===1====")
                        }
                    }.lparams {
                        weight = 1f
                    }
                    button("Cancel") {
                        setOnClickListener {
                            toast("===2====")
                        }
                    }.lparams {
                        weight = 1f
                    }
                }
                frameLayout {

                }
            }
        }.view)
    }
}