package com.project.danreading.di.components;

import android.content.Context;

import com.project.danreading.common.utils.ToastUtil;
import com.project.danreading.di.modules.AppMoudle;

import dagger.Component;

@Component(modules = AppMoudle.class)
public interface AppComponents {
    Context getContext();
    ToastUtil getTostUitl();
}
