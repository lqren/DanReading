package com.project.danreading.common.model;


import com.project.danreading.common.model.entity.Item;
import com.project.danreading.common.model.entity.SplashEntity;

import java.util.List;

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

    /**
     * <p>分类列表</p>
     * <p>http://static.owspace.com/?c=api&a=getList&p=1&model=1&page_id=0&create_time=0&client=android&version=1.3.0&time=1467867330&device_id=866963027059338&show_sdv=1</p>
     *
     * @param c
     * @param a
     * @param page
     * @param model(0:首页，1：文字，2：声音，3：影像，4：单向历)
     * @param pageId
     * @param time
     * @param deviceId
     * @param show_sdv
     * @return
     */
    @GET("")
    Observable<List<Item>> getList(@Query("c") String client,@Query("version") String version,@Query("a") String a,@Query("p") int p,@Query("model") int model,@Query("page_id") String pageId,@Query("create_time")String createTime,@Query("time") long time,@Query("device_id") String deviceId,@Query("show_sdv") int showSdv);

}
