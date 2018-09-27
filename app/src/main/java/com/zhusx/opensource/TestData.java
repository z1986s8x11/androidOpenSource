package com.zhusx.opensource;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.support.annotation.ColorInt;
import android.view.Gravity;
import android.widget.ProgressBar;

import com.zhusx.core.utils._Views;

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
}
