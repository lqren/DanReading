package com.project.danreading.common.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.project.danreading.R;
import com.project.danreading.app.DanReadApplication;
import com.project.danreading.common.utils.StatusBarUtil;
import com.project.danreading.di.components.AppComponent;
import com.project.danreading.di.components.NetComponent;
import com.tbruyelle.rxpermissions2.RxPermissions;

public class BaseActivity extends AppCompatActivity {

    public RxPermissions mRxPermissions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxPermissions = new RxPermissions(this);
        initStatus();
    }

    public void initStatus() {
        StatusBarUtil.compat(this, R.color.colorPrimary);
    }

    public AppComponent getAppComponents() {
        return ((DanReadApplication) getApplication()).getAppComponent();
    }

    public NetComponent getNetComponents() {
        return ((DanReadApplication) getApplication()).getNetComponent();
    }
}
