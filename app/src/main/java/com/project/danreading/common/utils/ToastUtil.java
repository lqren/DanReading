package com.project.danreading.common.utils;

import android.content.Context;
import android.widget.Toast;


/**
 *
 */
public class ToastUtil {

    private Context mContext;

    public ToastUtil(Context context) {
        mContext = context;
    }

    public void show(CharSequence text) {
        show(mContext, text, Toast.LENGTH_SHORT);
    }

    public void show(Context context, int resId) {
        show(context, context.getResources().getText(resId), Toast.LENGTH_SHORT);
    }

    public void show(Context context, int resId, int duration) {
        show(context, context.getResources().getText(resId), duration);
    }

    public void show(Context context, CharSequence text) {
        show(context, text, Toast.LENGTH_SHORT);
    }

    public void show(Context context, CharSequence text, int duration) {
        Toast mToast = null;
        if(mContext == null){
            mToast = Toast.makeText(context, text, duration);
        }else{
            mToast.setText(text);
        }
        mToast.show();
    }

    public void show(Context context, int resId, Object... args) {
        show(context, String.format(context.getResources().getString(resId), args), Toast.LENGTH_SHORT);
    }

    public void show(Context context, String format, Object... args) {
        show(context, String.format(format, args), Toast.LENGTH_SHORT);
    }

    public void show(Context context, int resId, int duration, Object... args) {
        show(context, String.format(context.getResources().getString(resId), args), duration);
    }

    public void show(Context context, String format, int duration, Object... args) {
        show(context, String.format(format, args), duration);
    }
}
