package com.qx.test;

import java.text.SimpleDateFormat;
import java.util.Date;


public class time {
    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间


    }
}
