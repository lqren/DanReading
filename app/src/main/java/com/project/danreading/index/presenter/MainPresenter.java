package com.project.danreading.index.presenter;


import android.os.SystemClock;

import com.project.danreading.common.model.ApiService;
import com.project.danreading.common.model.entity.Item;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private ApiService        mApiService;

    public MainPresenter(MainContract.View view, ApiService apiService) {
        mView = view;
        mApiService = apiService;
    }

    @Override
    public void getListByPage(int page, int model, String pageId, String deviceId, String createTime) {
        mApiService.getList("Android", "1.2.1", "Api", page, model, pageId, createTime, SystemClock.currentThreadTimeMillis(), deviceId, 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Item>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Item> items) {
                        if (items.size() > 0) {
                            mView.updateListUi(items);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getRecommend() {

    }
}
