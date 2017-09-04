package com.project.danreading.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

import javax.inject.Inject;

/**
 *
 */
public class AppUtil {
    private Context mContext;
    @Inject
    public AppUtil(Context context) {
        mContext = context;
    }

    /**
     * 返回版本信息
     *
     * @return
     */
    public PackageInfo getVersionInfo() {
        PackageManager packageManager = mContext.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(mContext.getPackageName(), 0);
            return packageInfo;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取版本设备id
     * @return
     */
    public String getDeviceId() {
         TelephonyManager tm = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

}
