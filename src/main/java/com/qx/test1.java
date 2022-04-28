package com.qx;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.security.SecureRandom;
import java.util.*;

/**
 * @author Xuan
 * Date: 2021/12/28
 * Time: 10:50
 */
public class test1 {
    public static void main(String[] args) {

        " sdf ".toCharArray();
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("aa",1);
        map.put("bb",4);
        map.put("cc",4);
        map.put("dd",3);
        map.put("ee",2);
        map.put("ff",8);
        map.forEach((a,b)->{
            System.out.println(a+" " +b);
        });
        List<Map.Entry<String,Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue();
            }
        });
        list.forEach((a)->System.out.println(a.getKey()));

//        Scanner in = new Scanner(System.in);
//
//        Map<String, Integer> map = new LinkedHashMap<String, Integer>();//LinkedHashMap而不是hashmap！！！！！
//        String key;
//        String filename;
//        String path;
//        while (in.hasNext()) {
//            path = in.next();
//            //将路径转换为文件名
//            int id = path.lastIndexOf('\\');
//            //如果找不到说明只有文件名没有路径
//            filename = id < 0 ? path : path.substring(id + 1);
//            int linenum = in.nextInt();
//            //统计频率
//            key = filename + " " + linenum;
//            if (map.containsKey(key)) {
//                map.put(key, map.get(key) + 1);
//            } else {
//                map.put(key, 1);
//            }
//        }
//
//        in.close();
//
//        //对记录进行排序
//        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return (o2.getValue() - o1.getValue()) == 0 ? (o1.getValue() - o2.getValue()) : (o2.getValue() - o1.getValue());
//            }
//
//        });
//        //只输出前8条
//        int m = 0;
//        for (Map.Entry<String, Integer> mapping : list) {
//            m++;
//            if (m <= 8) {
//                String[] str = mapping.getKey().split(" ");
//                String k = str[0].length() > 16 ? str[0].substring(str[0].length() - 16) : str[0];
//                String n = str[1];
//                System.out.println(k + " " + n + " " + mapping.getValue());
//            } else {
//                break;
//            }
//
//
//        }

//        String s = sc.nextLine();
//        String[] split = s.split("-");
//
//        String[] left = split[0].split(" ");
//        String[] right = split[1].split(" ");
//
//        if(left)
//        if(left.length!=right.length){
//            if()
//        }
//        if(left.length>4&&right.length>4){
//            System.out.println(split[right[0].compareTo(left[0])]);
//        }

//
//        BigInteger end = new BigInteger("6b9a031c7265f98",16);
//        BigInteger start = new BigInteger("68be2c3acfd2cd8",16);
//
//        System.out.println(end.subtract(start).divide(new BigInteger("8")));
//        System.out.println(String.format("%.9f %.9f",
//                xdag_log_difficulty2hashrate(Math.log(1609331816867416.0)),
//                xdag_log_difficulty2hashrate(Math.log(end.subtract(start).doubleValue()))));

//        BigInteger b = new BigInteger("123");
//        byte[] bytes = b.toByteArray();
//        System.out.println(Arrays.toString(bytes));
//        b = new BigInteger("240");
//        bytes = b.toByteArray();
//        System.out.println(Arrays.toString(bytes));

        PriorityQueue<Integer> queue;
        queue = new PriorityQueue<>(2);
        queue.add(10);
        queue.add(29);
        if (queue.add(-3)) {
            System.out.println("false");
        }

    }

    public static double xdag_log_difficulty2hashrate(double logDiff) {
        return Math.exp(logDiff) * Math.pow(2, -58) * (0.65);
    }
}
