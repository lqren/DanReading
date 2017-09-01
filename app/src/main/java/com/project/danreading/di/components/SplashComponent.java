package com.project.danreading.di.components;

import com.project.danreading.di.modules.SplashModule;
import com.project.danreading.index.view.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {SplashModule.class},dependencies = AppComponents.class)
@Singleton
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
