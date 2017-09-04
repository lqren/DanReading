package com.project.danreading.common.utils;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * 状态栏适配
 */
public class StatusBarUtil {
    private static final int INVALID_VAL   = -1;
    private static final int DEFAULT_COLOR = Color.parseColor("#20000000");
    @Inject
    public StatusBarUtil(){

    }
    public static void compat(Activity activity, int statusColor) {
        //大于等于5.0，在5.0以上是可以直接设置状态栏颜色的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (statusColor != INVALID_VAL) {
                activity.getWindow().setStatusBarColor(ContextCompat.getColor(activity, statusColor));
            }
            return;
        }

        //如果是大于等于4.4，小于6.0的，就创建一个与状态栏大小相同的view
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            int       color       = DEFAULT_COLOR;
            ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
            if (statusColor != INVALID_VAL) {
                color = statusColor;
            }
            View statusBarView = new View(activity);
            statusBarView.setBackgroundColor(color);
            int                    statusBarHeight = getStatusBarHeight(activity);
            ViewGroup.LayoutParams layoutParams    = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
            contentView.addView(statusBarView, layoutParams);
        }
    }

    public static void compat(Activity activity) {
        compat(activity, INVALID_VAL);
    }

    /**
     * 获取状态栏的高度
     *
     * @param context
     * @return
     */
    private static int getStatusBarHeight(Context context) {
        int result = 0;
        //获取指定包下的资源id
        int resultId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resultId > 0) {
            //根据指定资源id获取对应尺寸
            result = context.getResources().getDimensionPixelSize(resultId);
        }
        return result;
    }
}
