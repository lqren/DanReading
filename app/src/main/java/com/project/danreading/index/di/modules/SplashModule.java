package com.project.danreading.index.di.modules;


import com.project.danreading.index.presenter.SplashContract;

import dagger.Module;
import dagger.Provides;
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
