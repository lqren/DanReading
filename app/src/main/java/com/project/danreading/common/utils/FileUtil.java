package com.project.danreading.common.utils;


import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FileUtil {
    //文件存放路径
    private static final String FILE_SAVE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    //广告图片存放路径
    private static final String AD_FILE_PATH   = FILE_SAVE_PATH + File.separator + "DanRead";
   @Inject
    public FileUtil(){

    }
    /**
     * 获取所有的广告图片
     * @return
     */
    public List getAllAD() {
        ArrayList<String> imgList = new ArrayList<>();
        File file = new File(AD_FILE_PATH);
        String[] list = file.list();
        for (String filePath : list) {
            imgList.add(filePath);
        }

        return imgList;
    }
}
