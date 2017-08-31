package com.project.danreading.app;

import android.app.Application;
import android.content.Context;

import com.project.danreading.di.components.AppComponents;
import com.project.danreading.di.components.DaggerAppComponents;
import com.project.danreading.di.components.DaggerToastUtilComponent;
import com.project.danreading.di.components.ToastUtilComponent;
import com.project.danreading.di.modules.AppMoudle;
import com.project.danreading.di.modules.ToastUtilModule;


public class DanReadApplication extends Application {
    AppComponents mAppComponent;
    private ToastUtilComponent mToastUtilComponent;
    public static DanReadApplication get(Context context){
        return (DanReadApplication)context.getApplicationContext();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponents.builder().appMoudle(new AppMoudle(this)).build();
        initToast();
    }

    private void initToast() {
        mToastUtilComponent = DaggerToastUtilComponent.builder().toastUtilModule(new ToastUtilModule()).build();
    }

    public AppComponents getAppComponent() {
        return mAppComponent;
    }

    public ToastUtilComponent getToastUtilComponent() {
        return mToastUtilComponent;
    }
}
