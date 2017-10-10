package com.project.danreading.app;

import android.app.Application;
import android.content.Context;

import com.project.danreading.common.di.components.AppComponent;
import com.project.danreading.common.di.components.DaggerAppComponent;
import com.project.danreading.common.di.components.DaggerNetComponent;
import com.project.danreading.common.di.components.NetComponent;
import com.project.danreading.common.di.modules.AppMoudle;
import com.project.danreading.common.di.modules.NetModule;


public class DanReadApplication extends Application {
    private       NetComponent netComponent;
    public static Context      mContext;
    AppComponent mAppComponent;

    public static DanReadApplication get(Context context) {
        return (DanReadApplication) context.getApplicationContext();
    }

    public static Context getContext() {
       return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext =  getApplicationContext();
        mAppComponent = DaggerAppComponent.builder().appMoudle(new AppMoudle(this)).build();
        netComponent = DaggerNetComponent.builder().netModule(new NetModule()).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
