package com.project.danreading.common.utils;


import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class FileUtil {
    //文件存放路径
    private static final String FILE_SAVE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    //广告图片存放路径
    private static final String AD_FILE_PATH   = FILE_SAVE_PATH + File.separator + "DanRead";

    @Inject
    public FileUtil() {

    }

    /**
     * 获取所有的广告图片
     *
     * @return
     */
    public List getAllAD() {
        ArrayList<String> imgList = new ArrayList<>();
        File              file    = new File(AD_FILE_PATH);
        File[]            files   = file.listFiles();
        if (null != files) {
            for (File filePath : files) {
                imgList.add(filePath.getAbsolutePath());
            }
        }

        return imgList;
    }

    /**
     * 创建文件夹
     */
    public static void createSdDir() {
        File file = new File(AD_FILE_PATH);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    /**
     * 判断文件是否存在
     *
     * @param pictureName
     * @return
     */
    public static boolean isFileExist(String pictureName) {
        File file = new File(AD_FILE_PATH + File.separator + pictureName);
        if (file.exists()) {
            return true;
        }
        return false;
    }

    /**
     * 创建文件
     *
     * @param pictureName
     * @return
     */
    public static File createFile(String pictureName) {
        File file = new File(AD_FILE_PATH + File.separator + pictureName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
