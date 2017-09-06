package com.project.danreading.di.components;

import android.app.Activity;

import com.project.danreading.di.modules.MainModule;
import com.project.danreading.di.scope.UserScope;

import dagger.Component;

@Component (modules = MainModule.class,dependencies = {NetComponent.class,AppComponent.class})
@UserScope
public interface MainComponent {
    void inject(Activity activity);
}