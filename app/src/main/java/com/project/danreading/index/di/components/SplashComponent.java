package com.project.danreading.index.di.components;

import com.project.danreading.common.di.components.AppComponent;
import com.project.danreading.common.di.components.NetComponent;
import com.project.danreading.index.di.modules.SplashModule;
import com.project.danreading.common.di.scope.UserScope;
import com.project.danreading.index.view.activity.SplashActivity;

import dagger.Component;

@Component(modules = {SplashModule.class},dependencies = {NetComponent.class,AppComponent.class})
@UserScope
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
