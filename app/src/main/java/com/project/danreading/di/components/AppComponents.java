package com.project.danreading.di.components;

import android.content.Context;

import com.project.danreading.di.modules.AppMoudle;
import com.project.danreading.common.utils.ToastUtil;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = AppMoudle.class)
public interface AppComponents {
    Context getContext();
    ToastUtil getTostUitl();
}
