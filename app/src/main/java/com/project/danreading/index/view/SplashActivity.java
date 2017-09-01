package com.project.danreading.index.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.project.danreading.R;
import com.project.danreading.common.base.BaseActivity;
import com.project.danreading.common.utils.ToastUtil;
import com.project.danreading.di.components.DaggerSplashComponent;
import com.project.danreading.di.modules.SplashModule;
import com.project.danreading.index.presenter.SplashContract;
import com.project.danreading.index.presenter.SplashPresenter;

import javax.inject.Inject;


public class SplashActivity extends BaseActivity implements SplashContract.View {
    @Inject
    SplashPresenter mSplashPresenter;

    @Inject
    ToastUtil mToastUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        DaggerSplashComponent.builder().appComponents(getAppComponents()).splashModule(new SplashModule(this)).build().inject(this);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mToastUtil.show(SplashActivity.this, "Toast注册");
            }
        });
        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mToastUtil.show(SplashActivity.this, "Toast注册...............................");
            }
        });
    }
}
