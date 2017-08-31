package com.project.danreading.common.base;


import android.support.v7.app.AppCompatActivity;

import com.project.danreading.app.DanReadApplication;
import com.project.danreading.di.components.AppComponents;

public class BaseActivity extends AppCompatActivity {
    AppComponents mAppComponents;

    public AppComponents getAppComponents() {
        return ((DanReadApplication) getApplication()).getAppComponent();
    }
}
