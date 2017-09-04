package com.project.danreading.common.utils;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtil {

    /**
     * 获取当前网络是否可用
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm          = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[]       allNetworks = cm.getAllNetworkInfo();
        if (allNetworks != null) {
            for (int i = 0; i < allNetworks.length; i++) {
                if (allNetworks[i].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断网络环境
     * 默认是数据流量
     *
     * @return
     */
    public static NetType netType(Context context) {
        ConnectivityManager cm   = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        int                 type = cm.getActiveNetworkInfo().getType();
        if (type == ConnectivityManager.TYPE_WIFI) {
            return NetType.WIFI;
        } else if (type == ConnectivityManager.TYPE_MOBILE) {
            return NetType.TRAFFIC;
        }
        return NetType.TRAFFIC;
    }
        public enum NetType {
            WIFI, TRAFFIC
        }
    }
