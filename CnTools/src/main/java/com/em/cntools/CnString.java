package com.em.cntools;


import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author yemint
 */
public class CnString {
    private CnString() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("FmString cannot be instantiated");
    }

    /**
     * 判断字符串是否为null或""
     *
     * @param str
     * @return 为空或null返回true，否则返回false
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * 获取字符串长度
     */
    public static int length(CharSequence str) {
        return str == null ? 0 : str.length();
    }


    /**
     * utf-8编码
     */
    public static String utf8Encode(String str) {
        if (!isEmpty(str) && str.getBytes().length != str.length()) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(
                        "UnsupportedEncodingException occurred. ", e);
            }
        }
        return str;
    }

    public static String decodeString(String content) {
        if (content == null) {
            return "";
        }
        content = content.replace(" ", "+");
        try {
            String str = new String(Base64.decode(content.getBytes(), Base64.DEFAULT));
            if (str == null) {
                return "";
            }
            return str;
        } catch (Exception e) {
            return content;
        }
    }

    public static String encodeString(String content) {
        return Base64.encodeToString(content.getBytes(), Base64.DEFAULT);
    }
}
