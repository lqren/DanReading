package com.project.danreading.common.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.project.danreading.common.model.entity.Item;
import com.project.danreading.index.view.fragment.MainFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 */
public class VerticalPagerAdapter extends FragmentStatePagerAdapter {
    private List<Item> dataList =new ArrayList<>();
    @Inject
    public VerticalPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return MainFragment.instance(dataList.get(position));
    }

    @Override
    public int getCount() {
        return dataList.size();
    }
    public void setDataList(List<Item> data){
        dataList.addAll(data);
    }
    public String getLastItemId(){
        if (dataList.size()==0){
            return "0";
        }
        Item item = dataList.get(dataList.size()-1);
        return item.getId();
    }
    public String getLastItemCreateTime(){
        if (dataList.size()==0){
            return "0";
        }
        Item item = dataList.get(dataList.size()-1);
        return item.getCreate_time();
    }
}
