package com.project.danreading.di.modules;

import android.content.Context;

import com.project.danreading.common.utils.AppUtil;
import com.project.danreading.common.utils.FileUtil;
import com.project.danreading.common.utils.PrefrenceUtil;
import com.project.danreading.common.utils.ToastUtil;

import dagger.Module;
import dagger.Provides;

@Module
public class AppMoudle {
    Context mContext;

    public AppMoudle(Context context) {
        mContext = context;
    }

    @Provides
//    @Singleton
    public Context provideContext() {
        return mContext;
    }

    @Provides
//    @Singleton
    public ToastUtil provideToastUtil() {
        return new ToastUtil(mContext);
    }

    @Provides
//    @Singleton
    public AppUtil provideAppUtil() {
        return new AppUtil(mContext);
    }

    @Provides
//    @Singleton
    public FileUtil provideFileUtil() {
        return new FileUtil();
    }

    @Provides
//    @Singleton
    public PrefrenceUtil providePrefrenceUtil() {
        return new PrefrenceUtil(mContext);
    }

}
