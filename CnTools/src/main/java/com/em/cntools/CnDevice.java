package com.em.cntools;

import android.content.Context;
import android.telephony.TelephonyManager;

public class CnDevice {

    private CnDevice() {
        throw new UnsupportedOperationException("FmDevice cannot be instantiated");
    }

    /**
     * 获取设备的唯一标识，deviceId
     *
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//        String deviceId = tm.getDeviceId();
        String deviceId = null;
        if (deviceId == null) {
            return "";
        } else {
            return deviceId;
        }
    }

    /**
     * 获取手机品牌
     *
     * @return
     */
    public static String getPhoneBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机Android API等级（22、23 ...）
     *
     * @return
     */
    public static int getBuildLevel() {
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 获取手机Android 版本（4.4、5.0、5.1 ...）
     *
     * @return
     */
    public static String getBuildVersion() {
        return android.os.Build.VERSION.RELEASE;
    }


//    /**
//     * 获取手机所有的信息
//     *
//     * @param context
//     */
//    public static void getAppInfo(Context context) {
//        AppInfo mobileInfo = new AppInfo(context.getPackageName(), getAppName(context),
//                getVersionName(context), getVersionCode(context), getDeviceId(context),
//                getPhoneBrand(), getPhoneModel(), getBuildLevel() + "", getBuildVersion(), getCurrentTime());
//
//        FmLog.d("getAppInfo", mobileInfo.toString());
//    }
}
