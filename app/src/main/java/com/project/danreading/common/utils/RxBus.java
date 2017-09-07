package com.project.danreading.common.utils;


import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class RxBus {
    private static volatile RxBus                            mRxBus;
    private                 Relay<Object>                    mSubject;
    private                 Map<Class<?>, Object> mSubscriptionMap;

    private RxBus() {
        mSubject = PublishRelay.create().toSerialized();
        mSubscriptionMap = new ConcurrentHashMap<>();
    }

    public static RxBus getInstance() {
        if (mRxBus == null) {
            synchronized (RxBus.class) {
                if (mRxBus == null) {
                    mRxBus = new RxBus();
                }
            }
        }
        return mRxBus;
    }

    /**
     * 转成Observable
     *
     * @param clz
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> clz) {
        return mSubject.ofType(clz);
    }

    /**
     * 注册方式
     *
     * @param eventType
     * @param onNext
     * @param onError
     * @param <T>
     * @return
     */

    public <T> Disposable register(Class<T> eventType, Scheduler scheduler, Consumer<T> onNext, Consumer onError,
                                   Action onComplete, Consumer onSubscribe) {
        return toObservable(eventType).observeOn(scheduler).subscribe(onNext, onError, onComplete, onSubscribe);
    }

    public <T> Disposable register(Class<T> eventType, Scheduler scheduler, Consumer<T> onNext, Consumer onError,
                                   Action onComplete) {
        return toObservable(eventType).observeOn(scheduler).subscribe(onNext, onError, onComplete);
    }

    public <T> Disposable register(Class<T> eventType, Scheduler scheduler, Consumer<T> onNext, Consumer onError) {
        return toObservable(eventType).observeOn(scheduler).subscribe(onNext, onError);
    }

    public <T> Disposable register(Class<T> eventType, Consumer<T> onNext) {
        return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext);
    }

    public <T> Disposable register(Class<T> eventType, Consumer<T> onNext, Consumer onError,
                                   Action onComplete, Consumer onSubscribe) {
        return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onError, onComplete, onSubscribe);
    }

    public <T> Disposable register(Class<T> eventType, Consumer<T> onNext, Consumer onError,
                                   Action onComplete) {
        return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onError, onComplete);
    }

    public <T> Disposable register(Class<T> eventType, Consumer<T> onNext, Consumer onError) {
        return toObservable(eventType).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext, onError);
    }

    /**
     * 注册黏性事件
     * @param eventType
     * @param onNext
     * @param <T>
     * @return
     */
    public <T> Disposable registerSticky(Class<T> eventType, Consumer<T> onNext) {
        synchronized (mSubscriptionMap) {
            Observable<T>       tObservable = mRxBus.toObservable(eventType);
            Object              event           = mSubscriptionMap.get(eventType);
            if (event != null) {
                return tObservable.mergeWith(tObservable.create(e -> e.onNext(eventType.cast(event)))).observeOn(AndroidSchedulers.mainThread()).subscribe(onNext);
            } else {
                return tObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(onNext);
            }
        }
    }

    /**
     * 发送一个新Sticky事件
     */
    public void postSticky(Object event) {
        synchronized (mSubscriptionMap) {
            mSubscriptionMap.put(event.getClass(), event);
        }
        post(event);
    }


    /**
     * 发送事件
     *
     * @param o
     */
    public void post(Object o) {
        mSubject.accept(o);
    }

    /**
     * 是否有订阅者
     *
     * @return
     */
    public boolean hasObservers() {
        return mSubject.hasObservers();
    }

    /**
     * 取消注册
     */
    public void unregister(Disposable disposable) {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
