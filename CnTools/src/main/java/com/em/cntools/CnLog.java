package com.em.cntools;

import android.util.Log;

/**
 * @author yemint
 * Log统一管理类
 */
public class CnLog {

    private CnLog() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("FmLog cannot be instantiated");
    }

    public static boolean isDebug = AppConstants.isDebug;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "一枝Log出墙来:";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, canvs(null, msg));
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, canvs(null, msg));
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, canvs(null, msg));
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, canvs(null, msg));
    }

    // 下面是传入自定义tag的函数
    public static void i(String methodName, String msg) {
        if (isDebug)
            Log.i(TAG, canvs(methodName, msg));
    }

    public static void d(String methodName, String msg) {
        if (isDebug)
            Log.d(TAG, canvs(methodName, msg));
    }

    public static void e(String methodName, String msg) {
        if (isDebug)
            Log.e(TAG, canvs(methodName, msg));
    }

    public static String canvs(String name, String msg) {
        String b = "|\n|￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣￣|\n|";
        String c = "\n|-----------------------------------------------------------------------------------------------------|\n|";
        String d = "\n|＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿|";
        if (name == null) {
            name = TAG;
        }
        return b + "--------->" + name + c + "--------->" + msg + d;
    }


}
