package com.project.danreading.di.components;

import com.project.danreading.di.modules.SplashModule;
import com.project.danreading.di.scope.UserScope;
import com.project.danreading.index.view.activity.SplashActivity;

import dagger.Component;

@Component(modules = {SplashModule.class},dependencies = {NetComponent.class,AppComponent.class})
@UserScope
public interface SplashComponent {
    void inject(SplashActivity splashActivity);
}
