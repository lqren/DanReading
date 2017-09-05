package com.project.danreading.common.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.project.danreading.R;
import com.project.danreading.app.DanReadApplication;
import com.project.danreading.common.utils.StatusBarUtil;
import com.project.danreading.di.components.AppComponent;
import com.project.danreading.di.components.NetComponent;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatus();
    }

    public void initStatus() {
        StatusBarUtil.compat(this, R.color.colorTranslation);
    }

    public AppComponent getAppComponents() {
        return ((DanReadApplication) getApplication()).getAppComponent();
    }

    public NetComponent getNetComponents() {
        return ((DanReadApplication) getApplication()).getNetComponent();
    }
}
