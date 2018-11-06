package com.zhusx.replugin

import android.app.Activity
import android.os.Bundle
import org.jetbrains.anko.UI
import org.jetbrains.anko.textView
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

class TestPluginActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(UI {
            verticalLayout {
                textView("我是插件包里的") {
                    setOnClickListener { toast("==============") }
                }
            }
        }.view)
    }
}
