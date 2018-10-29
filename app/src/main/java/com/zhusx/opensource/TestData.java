package com.zhusx.opensource;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.view.Gravity;
import android.widget.ProgressBar;

import com.zhusx.core.debug.LogUtil;
import com.zhusx.core.utils._Views;

import java.util.Set;

/**
 * 测试数据
 * Author  zhusx
 * Email   327270607@qq.com
 * Create  2018/9/22 9:41
 */
public class TestData {
    public static String[] Images = new String[]{
            "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1534404681&di=4cb00a553998a24d0c0d5a30b3844f8f&src=http://lol.91danji.com/UploadFile/20141128/1417165228238101.jpg"
    };

    public static void setProgress(ProgressBar progressBar, @ColorInt int start, @ColorInt int end) {
        GradientDrawable p = new GradientDrawable();
        p.setCornerRadius(_Views.dip2px(1));
        p.setColor(start);
        ClipDrawable progress = new ClipDrawable(p, Gravity.LEFT, ClipDrawable.HORIZONTAL);
        GradientDrawable background = new GradientDrawable();
        background.setColor(end);
        background.setCornerRadius(_Views.dip2px(1));
        LayerDrawable pd = new LayerDrawable(new Drawable[]{background, progress});
        progressBar.setProgressDrawable(pd);
    }
    public static void debug(Intent intent) {
        StringBuffer sb = new StringBuffer();
        if (intent != null) {
            sb.append("Intent data:\n");
            sb.append(String.format("scheme:[ %s ]", intent.getScheme()));
            sb.append("\n");
            sb.append(String.format("uri:[ %s ]", intent.getData()));
            sb.append("\n");
            sb.append(String.format("type:[ %s ]", intent.getType()));
            sb.append("\n");
            sb.append(String.format("action:[ %s ]", intent.getAction()));
            sb.append("\n");
            sb.append(String.format("component:[ %s ]", intent.getComponent()));
            sb.append("\n");
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                sb.append("Intent bundle:\n");
                Set<String> set = bundle.keySet();
                for (String key : set) {
                    Object value = bundle.get(key);
                    if (value == null) {
                        sb.append(String.format("key:[ %s ]  value:[ %s ]", key, bundle.get(key)));
                    } else {
                        sb.append(String.format("key:[ %s ]  type:[ %s ]  value:[ %s ]", key, value.getClass().getName(), value));
                    }
                    sb.append("\n");
                }
            } else {
                sb.append("Intent bundle: null");
            }
        } else {
            sb.append("Intent data: null");
        }
        LogUtil.e(sb.toString());
    }

    public static void debug(Bundle bundle) {
        StringBuffer sb = new StringBuffer();
        if (bundle != null) {
            Set<String> set = bundle.keySet();
            for (String key : set) {
                Object value = bundle.get(key);
                if (value == null) {
                    sb.append(String.format("key:[ %s ]  value:[ %s ]", key, bundle.get(key)));
                } else {
                    sb.append(String.format("key:[ %s ]  type:[ %s ]  value:[ %s ]", key, value.getClass().getName(), value));
                }
                sb.append("\n");
            }
        } else {
            sb.append("Intent data: null");
        }
        LogUtil.e(sb.toString());
    }
}
