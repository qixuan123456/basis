package com.qx.shuati.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: xuan
 * Date: 2021/10/1
 * Time: 19:12
 */
public class No1436 {
    public static void main(String[] args) {
        System.out.println(destCity(Arrays.asList(Arrays.asList("a","b"),Arrays.asList("c","a"))));
    }
    public static String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}
