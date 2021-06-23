package com.em.cntools;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期处理相关工具类
 *
 * @author Yemint
 */
public class CnDate {
    /**
     * 定义常量
     **/
    public static final String DATE_JFP_STR = "yyyyMM";
    public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SMALL_STR = "yyyy-MM-dd";
    public static final String DATE_KEY_STR = "yyMMddHHmmss";

    private CnDate() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException(" FmDate cannot be instantiated");
    }

    /**
     * 使用预设格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @return
     */
    public static Date parse(String strDate) {
        return parse(strDate, DATE_FULL_STR);
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 两个时间比较
     *
     * @param date1
     * @return
     */
    public static int compareDateWithNow(Date date1) {
        Date date2 = new Date();
        int rnum = date1.compareTo(date2);
        return rnum;
    }

    /**
     * 两个时间比较(时间戳比较)
     *
     * @param date1
     * @return
     */
    public static int compareDateWithNow(long date1) {
        long date2 = dateToUnixTimestamp();
        if (date1 > date2) {
            return 1;
        } else if (date1 < date2) {
            return -1;
        } else {
            return 0;
        }
    }


    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getNowTime() {
        SimpleDateFormat df = new SimpleDateFormat(DATE_FULL_STR);
        return df.format(new Date());
    }

    /**
     * 获取系统当前时间
     *
     * @return
     */
    public static String getNowTime(String type) {
        SimpleDateFormat df = new SimpleDateFormat(type);
        return df.format(new Date());
    }

    /**
     * 获取系统当前计费期
     *
     * @return
     */
    public static String getJFPTime() {
        SimpleDateFormat df = new SimpleDateFormat(DATE_JFP_STR);
        return df.format(new Date());
    }

    /**
     * 将指定的日期转换成Unix时间戳
     *
     * @param date date 需要转换的日期 yyyy-MM-dd HH:mm:ss
     * @return long 时间戳
     */
    public static long dateToUnixTimestamp(String date) {
        long timestamp = 0;
        try {
            timestamp = new SimpleDateFormat(DATE_FULL_STR).parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    /**
     * 将指定的日期转换成Unix时间戳
     *
     * @param date date 需要转换的日期 yyyy-MM-dd
     * @return long 时间戳
     */
    public static long dateToUnixTimestamp(String date, String dateFormat) {
        long timestamp = 0;
        try {
            timestamp = new SimpleDateFormat(dateFormat).parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timestamp;
    }

    /**
     * 将当前日期转换成Unix时间戳
     *
     * @return long 时间戳
     */
    public static long dateToUnixTimestamp() {
        long timestamp = new Date().getTime();
        return timestamp;
    }


    /**
     * 将Unix时间戳转换成日期
     *
     * @param timestamp timestamp 时间戳
     * @return String 日期字符串
     */
    public static String unixTimestampToDate(long timestamp) {
        SimpleDateFormat sd = new SimpleDateFormat(DATE_FULL_STR);
        sd.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sd.format(new Date(timestamp));
    }

    /**
     * 获取当前时间戳
     *
     * @return 时间戳
     */
    public static long getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

//    /**
//     * Parse the time in milliseconds into String with the format: hh:mm:ss or mm:ss
//     *
//     * @param duration The time needs to be parsed.
//     */
//    @SuppressLint("DefaultLocale")
//    public static String formatDuration(long duration) {
//        duration /= 1000; // milliseconds into seconds
//        long minute = duration / 60;
//        long hour = minute / 60;
//        minute %= 60;
//        long second = duration % 60;
//        if (hour != 0)
//            return String.format("%2d:%02d:%02d", hour, minute, second);
//        else
//            return String.format("%02d:%02d", minute, second);
//    }

    /**
     * 日期转时间戳 样式 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static long DateToShiJianChuo(String datestr) {
        String endalltime = CnDate.getYear() + "-" + CnDate.getMonth()
                + "-" + CnDate.getDay() + " " + datestr + ":00";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(endalltime);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            return 0;
        }
        return date.getTime();
    }

    /**
     * 获取当前年
     *
     * @return 年
     */
    public static String getYear() {
        return format(getCurrentTime(), "yyyy");
    }

    /**
     * 获取当前月
     *
     * @return 月
     */
    public static String getMonth() {
        return format(getCurrentTime(), "MM");
    }

    /**
     * 获取当前日
     *
     * @return 日
     */
    public static String getDay() {
        return format(getCurrentTime(), "dd");
    }


    /**
     * 格式化时间,自定义格式
     *
     * @param time     时间
     * @param formater 格式化时间用的标签
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String format(long time, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(new Date(time));
    }

    /**
     * 将日期以yyyy-MM-dd HH:mm:ss格式化
     *
     * @param date 日期
     * @return
     */
    @SuppressLint("SimpleDateFormat")
    public static String format(Date date, String formater) {
        SimpleDateFormat sdf = new SimpleDateFormat(formater);
        return sdf.format(date);
    }

    /**
     * 以毫秒为单位的时间 解析成字符串格式: hh:mm:ss 或mm:ss
     *
     * @param duration
     * @return
     */
    public static String formatDuration(long duration) {
        duration /= 1000; // milliseconds into seconds
        long minute = duration / 60;
        long hour = minute / 60;
        minute %= 60;
        long second = duration % 60;
        if (hour != 0)
            return String.format("%2d:%02d:%02d", hour, minute, second);
        else
            return String.format("%02d:%02d", minute, second);
    }


}
