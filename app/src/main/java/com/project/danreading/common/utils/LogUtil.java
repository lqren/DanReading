package com.project.danreading.common.utils;

import android.util.Log;

/**
 *  Log日志工具类
 */
public class LogUtil {
    private static boolean ISSHOW = true;
    private static final int VERBOSE = 5;
    private static final int DEBUG = 4;
    private static final int INFO = 3;
    private static final int WARN = 2;
    private static final int ERROR = 1;
    private static int LEVEL = VERBOSE;

    /**
     * 得到当前线程堆的数组
     * @return
     */
    private static StackTraceElement getSatackTraceElement(){
        return Thread.currentThread().getStackTrace()[4];
    }

    private static String getTag(StackTraceElement stackTraceElement){
        String clazzName = stackTraceElement.getClassName();
        clazzName = clazzName.substring(clazzName.indexOf(".")+1);
        String tag = "%s";
        tag = String.format(tag,clazzName);
        return tag;
    }
    /**
     * verbose打印
     * @param msg
     */
    public static void v(String msg) {
        if (!ISSHOW) {
            return;
        }
        if(LEVEL <= VERBOSE){
            Log.v(getTag(getSatackTraceElement()), msg);
        }

    }
    /**
     * debug打印
     * @param msg
     */
    public static void d(String msg) {
        if (!ISSHOW) {
            return;
        }
        if(LEVEL <= DEBUG){
            Log.d(getTag(getSatackTraceElement()), msg);
        }

    }

    /**
     * info
     * @param msg
     */
    public static void i(String msg) {
        if (!ISSHOW) {
            return;
        }
        if(LEVEL <= INFO){
            Log.i(getTag(getSatackTraceElement()), msg);
        }
    }

    /**
     * error
     * @param msg
     */
    public static void e(String msg) {
        if (!ISSHOW) {
            return;
        }
        if(LEVEL <= ERROR){
            Log.e(getTag(getSatackTraceElement()), msg);
        }
    }

    /**
     * warn
     * @param msg
     */
    public static void w(String msg) {
        if (!ISSHOW) {
            return;
        }
        if(LEVEL <= WARN){
            Log.w(getTag(getSatackTraceElement()), msg);
        }
    }
}
