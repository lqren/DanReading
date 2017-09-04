package com.project.danreading.di.components;

import android.content.Context;

import com.project.danreading.common.utils.AppUtil;
import com.project.danreading.common.utils.FileUtil;
import com.project.danreading.common.utils.PrefrenceUtil;
import com.project.danreading.common.utils.ToastUtil;
import com.project.danreading.di.modules.AppMoudle;

import dagger.Component;

@Component(modules = AppMoudle.class)
public interface AppComponent {
    Context getContext();
    ToastUtil getTostUitl();
    AppUtil getAppUtil();
    FileUtil getFileUtil();
    PrefrenceUtil getPrefrenceUtil();
}
