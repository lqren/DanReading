package com.project.danreading.common.utils;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class HttpUtil {
    private HttpUtil(){}
    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .build();
}
