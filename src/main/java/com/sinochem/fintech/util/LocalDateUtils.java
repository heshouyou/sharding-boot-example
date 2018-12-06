package com.sinochem.fintech.util;

import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2018/12/6 14:27
 */
public class LocalDateUtils {

    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static String getCurrentDateStr(){
        return dateFormat.format(new Date());
    }
}
