package com.project.danreading.di.components;


import com.project.danreading.di.modules.MainModule;
import com.project.danreading.di.scope.UserScope;
import com.project.danreading.index.view.MainActivity;

import dagger.Component;

@Component (modules = {MainModule.class},dependencies = {NetComponent.class,AppComponent.class})
@UserScope
public interface MainComponent {
    void inject(MainActivity activity);
}
