package com.em.cntools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * toast工具类
 *
 * @author yemint
 */
public class CnToast {

    private CnToast() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean isShow = AppConstants.isShowToast;


    /**
     * 显示长时间 自定义的Toast
     *
     * @param message
     */
    @SuppressLint("ResourceAsColor")
    private static void show(CharSequence message, int time, int modle) {
        if (isShow) {

            if (AppConstants.app != null) {

                Context context = AppConstants.app;

                CnLog.d(context.getPackageName(), message.toString());

                Toast toast = Toast.makeText(context, message, time);
                int hight = 0;
                if (AppConstants.isShowState) {
                    hight = CnScreen.getStatusHeight(context);
                }
                toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, hight);

                View layout = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);


                layout.setBackgroundResource(getBGIdByMode(modle));

                TextView textView = layout.findViewById(R.id.tv_toast);
                ImageView imageView = layout.findViewById(R.id.iv_toast);
                if (modle != 1) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageResource(getImIdByMode(modle));
                    textView.setGravity(Gravity.CENTER_VERTICAL);
                }
                textView.setText(message);

                toast.setView(layout);
                toast.show();
            }

        }

    }

    /**
     * 长时间 显示正常的Toast
     *
     * @param message
     */
    public static void showL(CharSequence message) {
        if (isShow)
            show(message, Toast.LENGTH_LONG, MSG_NORMAL);
    }

    /**
     * 短时间 显示正常的Toast
     *
     * @param message
     */
    public static void showS(CharSequence message) {
        if (isShow)
            show(message, Toast.LENGTH_SHORT, MSG_NORMAL);
    }

    public static void sucess(CharSequence message) {
        if (isShow)
            show(message, Toast.LENGTH_LONG, MSG_SUCESS);
    }

    public static void error(CharSequence message) {
        if (isShow)
            show(message, Toast.LENGTH_LONG, MSG_ERROR);
    }

    public static void info(CharSequence message) {
        if (isShow)
            show(message, Toast.LENGTH_LONG, MSG_INFO);
    }


    private static final int MSG_NORMAL = 1;
    private static final int MSG_INFO = 2;
    private static final int MSG_SUCESS = 3;
    private static final int MSG_ERROR = 4;

    private static int getBGIdByMode(int mode) {
        switch (mode) {
            case MSG_NORMAL:
                return R.color.nomo;
            case MSG_INFO:
                return R.color.info;
            case MSG_SUCESS:
                return R.color.success;
            case MSG_ERROR:
                return R.color.error;
        }
        return 0;
    }

    private static int getImIdByMode(int mode) {
        switch (mode) {
            case MSG_NORMAL:
                return MSG_NORMAL;
            case MSG_INFO:
                return R.drawable.info;
            case MSG_SUCESS:
                return R.drawable.success;
            case MSG_ERROR:
                return R.drawable.error;
        }
        return 0;
    }
}