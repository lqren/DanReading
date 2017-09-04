package com.project.danreading.common.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.inject.Inject;

/**
 * 版权所有 Administrator
 */
public class PrefrenceUtil {
    private static SharedPreferences        mSp;
    private static SharedPreferences.Editor mEditor;

    @Inject
    public PrefrenceUtil(Context context) {
        mSp = context.getSharedPreferences("plm", Context.MODE_PRIVATE);
        mEditor = mSp.edit();
    }

    /**
     * 取出String
     */
    public String getString(String key, String defValue) {
        return mSp.getString(key, defValue);
    }

    /**
     * 取出int
     */
    public int getInt(String key, int defValue) {
        return mSp.getInt(key, defValue);
    }

    /**
     * 取出long
     */
    public long getLong(String key, long defValue) {
        return mSp.getLong(key, defValue);
    }

    /**
     * 取出boolean
     */
    public boolean getBoolean(String key, boolean defValue) {
        return mSp.getBoolean(key, defValue);
    }

    /**
     * 存入String
     */
    public void putString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    /**
     * 存入int
     */
    public void putInt(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    /**
     * 存入Long
     */
    public void putLong(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    /**
     * 存入boolean
     */
    public void putBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    /**
     * 将list集合转成String
     *
     * @return
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public String list2String(Object list) throws IOException {
        //实例化一个ByteArrayOutputStream来装载压缩后的字节文件
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream    objectOutputStream    = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(list);
        String listString = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        //关闭流
        objectOutputStream.close();
        return listString;
    }

    /**
     * 将String转成List集合
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public Object str2List(String str) throws Exception {
        byte[]               decode                = Base64.decode(str.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream byteArrayOutputStream = new ByteArrayInputStream(decode);
        ObjectInputStream    objectInputStream     = new ObjectInputStream(byteArrayOutputStream);
        Object               object                = objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }

    public static String trim(String s){
        String result = "";
        if(null!=s && !"".equals(s)){
            result = s.replaceAll("^[　*| *| *|//s*]*", "").replaceAll("[　*| *| *|//s*]*$", "");
        }
        return result;
    }
}
