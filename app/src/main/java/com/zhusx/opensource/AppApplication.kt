package com.zhusx.opensource

import com.facebook.drawee.backends.pipeline.Fresco
import com.qihoo360.replugin.RePluginApplication
import com.qihoo360.replugin.RePluginConfig
import com.zhusx.core.ZsxApplicationManager

/**
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/8/14 9:36
 */
class AppApplication : RePluginApplication() {
    override fun onCreate() {
        super.onCreate()
        ZsxApplicationManager.builder(this).setLogDebug(BuildConfig.DEBUG).build()
        //初始化fresco框架
        Fresco.initialize(this)
    }

    override fun createConfig(): RePluginConfig {
        val c = RePluginConfig()
        c.verifySign = !BuildConfig.DEBUG
        c.isMoveFileWhenInstalling = !BuildConfig.DEBUG
        c.isPrintDetailLog = BuildConfig.DEBUG
        return c
    }
}
