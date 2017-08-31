package com.project.danreading.index.view;

import android.os.Bundle;

import com.project.danreading.R;
import com.project.danreading.common.base.BaseActivity;
import com.project.danreading.common.utils.ToastUtil;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
