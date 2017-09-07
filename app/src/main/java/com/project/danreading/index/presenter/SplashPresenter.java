package com.project.danreading.index.presenter;


import android.os.SystemClock;

import com.project.danreading.common.model.ApiService;
import com.project.danreading.common.model.entity.SplashEntity;
import com.project.danreading.common.utils.LogUtil;
import com.project.danreading.common.utils.NetworkUtil;
import com.project.danreading.common.utils.OkHttpImageDownLoaderUtil;
import com.project.danreading.index.view.activity.SplashActivity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SplashPresenter implements SplashContract.Presenter {
    private SplashContract.View mView;
    private ApiService mApiService;

    @Inject
    public SplashPresenter(SplashContract.View view, ApiService apiService) {
        mView = view;
        mApiService = apiService;
    }

    @Override
    public void getSplash(String deviceId) {
        String client = "android";
        String version = "1.1.0";
        mApiService.getSplash(client,version,deviceId,SystemClock.currentThreadTimeMillis())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SplashEntity>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull SplashEntity splashEntity) {
                        //检验当前是否是WiFi环境
                        if(NetworkUtil.netType(((SplashActivity)mView).getAppComponents().getContext()) == NetworkUtil.NetType.WIFI){
                            List<String> images = splashEntity.getImages();
                            for (String image : images) {
                                //去下载服务器上的广告图片到本地
                                OkHttpImageDownLoaderUtil.down(image);
                            }

                        }else{
                            LogUtil.d("非WiFi环境，不下载图片");
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        LogUtil.e("load splash failed:");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
