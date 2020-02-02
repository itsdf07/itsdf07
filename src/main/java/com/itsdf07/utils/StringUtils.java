package com.itsdf07.utils;

/**
 * @Description:
 * @Author itsdf07
 * @E-Mail 923255742@qq.com
 * @Github https://github.com/itsdf07
 * @Date 2020/2/2
 */
public class StringUtils {
    /**
     * 判断字符串是否为空或者空内容
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (null == str || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
