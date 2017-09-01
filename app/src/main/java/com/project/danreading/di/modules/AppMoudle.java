package com.project.danreading.di.modules;

import android.content.Context;

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

}
