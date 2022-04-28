package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author xuan
 * @date 2022/4/20 12:25
 */
public class No388 {
    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(input));
    }

    public static int lengthLongestPath(String input) {
        Map<Integer, String> map = new HashMap<>();
        int ans = 0;
        String[] strings = input.split("\\n");
        for (String string : strings) {
            int key = 0;
            int j = 0;
            for (; j < string.length(); j++) {
                if (string.charAt(j) == '\t' ) {
                    key++;
                }else {
                    break;
                }
            }

            String value = string.substring(j);
            map.put(key, value);
            if (value.contains(".")) {
                int len = 0;
                int amount = 0;
                for (Map.Entry<Integer, String> entry : map.entrySet()) {
                    if (entry.getKey() <= key) {
                        len += entry.getValue().length();
                        amount++;
                    }
                }
                if(amount>0){
                    amount = amount-1;
                }
                ans = Math.max(ans, len+amount);
            }
        }
        return ans;
    }
}
