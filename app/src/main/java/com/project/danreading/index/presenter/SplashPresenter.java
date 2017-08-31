package com.project.danreading.index.presenter;


import javax.inject.Inject;

public class SplashPresenter implements SplashContract.Presenter {
    private SplashContract.View mView;
    @Inject
    public SplashPresenter(SplashContract.View view) {
        mView = view;
    }

    @Override
    public void getSplash(String deviceId) {

    }
}
