package com.zhusx.opensource.plugin

//class PluginActivity : Activity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(UI {
//            verticalLayout {
//                button("判断插件是否运行") {
//                    setOnClickListener {
//                        if (RePlugin.isPluginRunning("demo1")) {
//                            toast("插件正在运行")
//                        } else {
//                            toast("插件未运行")
//                        }
//                    }
//                }
//                button("加载插件") {
//                    setOnClickListener {
//                        if (RePlugin.preload("demo1")) {
//                            toast("加载插件成功")
//                        } else {
//                            toast("加载插件失败")
//                        }
////                        val pi = RePlugin.install("plugin")
////                        if (pi != null) {
////                            RePlugin.preload(pi)
////                            toast("加载插件成功")
////                        } else {
////                            toast("加载插件失败")
////                        }
//                    }
//                }
//                button("跳转") {
//                    setOnClickListener {
//                        RePlugin.startActivity(this@PluginActivity, RePlugin.createIntent("news.abb.com.plugin", "news.abb.com.plugin.TestPluginActivity"))
//                    }
//                }
//                button("跳转Demo插件") {
//                    setOnClickListener {
//                        RePlugin.startActivity(this@PluginActivity, RePlugin.createIntent("com.qihoo360.replugin.sample.demo1", "com.qihoo360.replugin.sample.demo1.MainActivity"))
//                    }
//                }
//            }
//        }.view)
//    }
//}