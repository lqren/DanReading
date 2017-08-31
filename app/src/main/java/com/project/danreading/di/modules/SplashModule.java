package com.project.danreading.di.modules;


import com.project.danreading.di.scope.UserScope;
import com.project.danreading.index.presenter.SplashContract;

import dagger.Module;
import dagger.Provides;
@UserScope
@Module
public class SplashModule {
    private SplashContract.View mView;

    public SplashModule(SplashContract.View view) {
        mView = view;
    }

    @Provides
    public SplashContract.View provideView() {
        return mView;
    }
}
