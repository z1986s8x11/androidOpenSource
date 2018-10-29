package com.zhusx.opensource;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhusx.core.ZsxApplicationManager;

/**
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/8/14 9:36
 */
public class AppApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZsxApplicationManager.builder(this).setLogDebug(BuildConfig.DEBUG).build();
        //初始化fresco框架
        Fresco.initialize(this);
    }
}
