package com.project.danreading.index.presenter;


import com.project.danreading.common.model.entity.Item;

import java.util.List;

public interface MainContract {
    interface Presenter {
        void getListByPage(int page, int model, String pageId, String deviceId, String createTime);

        void getRecommend();
    }

    interface View {
        void updateListUi(List<Item> lists);
    }
}
