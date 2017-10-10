package com.project.danreading.index.di.components;


import com.project.danreading.common.di.components.AppComponent;
import com.project.danreading.common.di.components.NetComponent;
import com.project.danreading.index.di.modules.MainModule;
import com.project.danreading.common.di.scope.UserScope;
import com.project.danreading.index.view.activity.MainActivity;

import dagger.Component;

@Component (modules = {MainModule.class},dependencies = {NetComponent.class,AppComponent.class})
@UserScope
public interface MainComponent {
    void inject(MainActivity activity);
}
