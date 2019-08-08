package com.zhusx.opensource

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.zhusx.core.ZsxApplicationManager

/**
 * https://github.com/Qihoo360/RePlugin/
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/8/14 9:36
 */
class AppApplication : /*RePluginApplication*/Application() {
    override fun onCreate() {
        super.onCreate()
        ZsxApplicationManager.builder(this).setLogDebug(BuildConfig.DEBUG).build()
        //初始化fresco框架
        Fresco.initialize(this)
    }

//    override fun createConfig(): RePluginConfig {
//        val c = RePluginConfig()
//        //是否效验签名
//        c.verifySign = !BuildConfig.DEBUG
//        //白名单
//        RePlugin.addCertSignature("379C790B7B726B51AC58E8FCBCFEB586")
//        c.isMoveFileWhenInstalling = !BuildConfig.DEBUG
//        c.isPrintDetailLog = BuildConfig.DEBUG
//        c.callbacks = object : RePluginCallbacks(this) {
//            //在启动插件  么有的时候会回调这个
//            override fun onPluginNotExistsForActivity(context: Context?, plugin: String?, intent: Intent?, process: Int): Boolean {
//                Log.e("====", "plugin:${plugin} intent:${intent}")
//                return super.onPluginNotExistsForActivity(context, plugin, intent, process)
//            }
//        }
//        return c
//    }
//
//    fun load(pluginName: String) {
//        if (RePlugin.isPluginRunning(pluginName)) {
//            toast("插件正在运行")
//        } else {
//            toast("插件未运行")
//            val pi = RePlugin.install(File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "6demo1.jar").path)
//            if (pi != null) {
//                RePlugin.preload(pi)
//                toast("加载插件成功")
//                //跳转  如果不存在此插件  会调用 onPluginNotExistsForActivity 方法
//                RePlugin.startActivity(this, RePlugin.createIntent("news.abb.com.plugin", "news.abb.com.plugin.TestPluginActivity"))
//            } else {
//                toast("加载插件失败")
//            }
//        }
//    }
}
