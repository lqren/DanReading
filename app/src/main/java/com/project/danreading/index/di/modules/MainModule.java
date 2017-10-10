package com.project.danreading.index.di.modules;


import android.support.v4.app.FragmentManager;

import com.project.danreading.common.view.adapter.VerticalPagerAdapter;
import com.project.danreading.index.presenter.MainContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private MainContract.View mView;

    public MainModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    public MainContract.View proviceView() {
        return mView;
    }

    @Provides
    public VerticalPagerAdapter provideVerticalPagerAdapter(FragmentManager fm){
        return new VerticalPagerAdapter(fm);
    }
}
