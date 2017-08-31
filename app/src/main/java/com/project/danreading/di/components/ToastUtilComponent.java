package com.project.danreading.di.components;

import com.project.danreading.common.utils.ToastUtil;
import com.project.danreading.di.modules.ToastUtilModule;

import dagger.Component;

/**
 * Created by Administrator on 2017/8/31.
 */
@Component(modules = ToastUtilModule.class)
public interface ToastUtilComponent {
    ToastUtil inject();
}
