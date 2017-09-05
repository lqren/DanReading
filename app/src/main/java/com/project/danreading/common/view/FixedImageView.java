package com.project.danreading.common.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.Display;


public class FixedImageView extends AppCompatImageView {
    private Context mContext;
    private int mWidth;
    private int mHeight;

    public FixedImageView(Context context) {
        this(context, null);
    }

    public FixedImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        getScreenSize();
    }

    /**
     * 获取屏幕尺寸
     */
    public void getScreenSize() {
        Display defaultDisplay = ((Activity) mContext).getWindowManager().getDefaultDisplay();
        mWidth = defaultDisplay.getWidth();
        mHeight = defaultDisplay.getHeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(size,mHeight);
    }
}
