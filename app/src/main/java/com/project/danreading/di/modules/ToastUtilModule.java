package com.project.danreading.di.modules;

import com.project.danreading.common.utils.ToastUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/8/31.
 */
@Module
public class ToastUtilModule {
    @Provides
    public ToastUtil provideToastUtil(){
        return new ToastUtil();
    }
}
