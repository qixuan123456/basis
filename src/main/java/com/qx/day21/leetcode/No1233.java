package com.qx.day21.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xuan
 * @date 2022/6/8 14:28
 */
public class No1233 {
    public static void main(String[] args) {
        System.out.println(removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
    }

    public static List<String> removeSubfolders(String[] folder) {
        final String[] s = {"nnnnnn"};
        return Arrays.stream(folder).sorted().filter(s1 -> {
            if(s1.indexOf(s[0])==0){
                return false;
            }else {
                s[0] = s1+"/";
                return true;
            }
        }).collect(Collectors.toList());
    }
}
