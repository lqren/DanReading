package com.project.danreading.index.view.activity;

import android.Manifest;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.project.danreading.R;
import com.project.danreading.common.base.BaseActivity;
import com.project.danreading.common.utils.AppUtil;
import com.project.danreading.common.utils.FileUtil;
import com.project.danreading.common.utils.PrefrenceUtil;
import com.project.danreading.common.utils.ToastUtil;
import com.project.danreading.common.view.FixedImageView;
import com.project.danreading.common.di.components.DaggerSplashComponent;
import com.project.danreading.index.di.modules.SplashModule;
import com.project.danreading.index.presenter.SplashContract;
import com.project.danreading.index.presenter.SplashPresenter;
import com.tbruyelle.rxpermissions2.RxPermissions;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SplashActivity extends BaseActivity implements SplashContract.View {
    @Inject
    SplashPresenter mSplashPresenter;
    @Inject
    ToastUtil       mToastUtil;
    @Inject
    AppUtil         mAppUtil;
    @Inject
    FileUtil        mFileUtil;
    @Inject
    PrefrenceUtil   mPrefrenceUtil;
    private static final String SPLASH_IMG_INDEX = "splash_img_index";
    @BindView(R.id.splash_iv)
    FixedImageView mSplashIv;
    private RxPermissions mRxPermissions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSplashComponent.builder().netComponent(getNetComponents()).appComponent(getAppComponents()).splashModule(new SplashModule(this)).build().inject(this);
        mRxPermissions = new RxPermissions(this);
        requestPermission();
    }



    /**
     * 请求权限
     */
    private void requestPermission() {
        mRxPermissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE)
                .subscribe(granted -> {
                    if (granted) {
                        setContentView(R.layout.activity_splash);
                        ButterKnife.bind(this);
                        delaySplash();
                        String deviceId = mAppUtil.getDeviceId();
                        getSplash(deviceId);
                    } else {
                        String str = "权限被拒绝";
                      /*  switch (permission.name) {
                            case Manifest.permission.WRITE_EXTERNAL_STORAGE:
                            case Manifest.permission.READ_EXTERNAL_STORAGE:
                                str = "文件读写权限被拒绝!";
                                break;
                            case Manifest.permission.READ_PHONE_STATE:
                                str = "获取手机状态权限被拒绝!";
                                break;
                            default:
                                break;*/
//                        }
                        mToastUtil.show(str);
                    }
                });
    }


    /**
     * 加载欢迎页
     */
    private void delaySplash() {
        List<String> allAD = mFileUtil.getAllAD();
        if (allAD.size() > 0) {
            Random random   = new Random();
            int    ADIndex = random.nextInt(allAD.size());
            int    imgIndex  = mPrefrenceUtil.getInt(SPLASH_IMG_INDEX, 0);
            if (imgIndex == ADIndex) {
                if (ADIndex >= allAD.size()) {
                    ADIndex--;
                } else if (ADIndex == 0) {
                    if (ADIndex + 1 < allAD.size()) {
                        ADIndex++;
                    }
                }
            }
            mPrefrenceUtil.putInt(SPLASH_IMG_INDEX, ADIndex);
            File file = new File(allAD.get(ADIndex));

            try {
                InputStream fis = new FileInputStream(file);
                mSplashIv.setImageDrawable(inputStream2Drawable(fis));
                startWelcomAnimation();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            try {
                AssetManager assetManager = getAssets();
                InputStream  fis         = assetManager.open("welcome_default.jpg");
                mSplashIv.setImageDrawable(inputStream2Drawable(fis));
                startWelcomAnimation();
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 开始欢迎界面的动画
     */
    private void startWelcomAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mSplashIv,"translationX",-100f);
        objectAnimator.setDuration(1500).start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    private Drawable inputStream2Drawable(InputStream fis) {
        Drawable splashImg = BitmapDrawable.createFromStream(fis, "splashImg");
        return splashImg;
    }

    /**
     * 获取欢迎页广告信息
     *
     * @param deviceId
     */
    private void getSplash(String deviceId) {
        mSplashPresenter.getSplash(deviceId);
    }
}
