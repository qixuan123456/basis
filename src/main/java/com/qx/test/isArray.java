package com.qx.test;

import java.util.HashMap;
import java.util.Map;

public class isArray {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","2");
        map.put("2","2");
        map.put("3","2");
        System.out.println( map.getClass().isArray());
    }
}
