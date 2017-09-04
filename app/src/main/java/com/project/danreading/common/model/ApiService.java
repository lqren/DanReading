package com.project.danreading.common.model;


import com.project.danreading.common.model.entity.SplashEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    /**
     * http://static.owspace.com/static/picture_list.txt?client=android&version=1.3.0&time=1467864021&device_id=866963027059338
     * @param client
     * @param version
     * @param device_id
     * @param time
     * @return
     */
    @GET("static/picture_list.txt")
    Observable<SplashEntity> getSplash(@Query("client") String client,@Query("version") String version,@Query("device_id") String device_id,@Query("time") long time);
}
