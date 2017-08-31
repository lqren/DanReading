package com.project.danreading.app;

import android.app.Application;

import com.project.danreading.di.components.AppComponents;
import com.project.danreading.di.components.DaggerAppComponents;
import com.project.danreading.di.modules.AppMoudle;


public class DanReadApplication extends Application {
    AppComponents mAppComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent =  DaggerAppComponents.builder().appMoudle(new AppMoudle(this)).build();
    }

    public AppComponents getAppComponent(){
        return mAppComponent;
    }
}
