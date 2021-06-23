package com.em.cntools;

import android.app.Application;

public class CnTools {

    public static void init(Application app) {
        AppConstants.app = app;
    }

    public static void init(Application app, boolean isDebug) {
        AppConstants.app = app;
        AppConstants.isDebug = isDebug;

    }

    public static void init(Application app, boolean isDebug, boolean isShowToast) {
        AppConstants.app = app;
        AppConstants.isDebug = isDebug;
        AppConstants.isShowState = isShowToast;
    }

    public static void init(Application app, boolean isDebug, boolean isShowToast, boolean isShowState) {
        AppConstants.app = app;
        AppConstants.isDebug = isDebug;
        AppConstants.isShowToast = isShowToast;
        AppConstants.isShowState = isShowState;
    }


}
