package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/5/17 18:05
 */
public class No949 {
    public static void main(String[] args) {
        No949 no949 = new No949();
        System.out.println(no949.largestTimeFromDigits(new int[]{0,0,0,0}));
    }

    public String largestTimeFromDigits(int[] arr) {
        boolean[] flag = new boolean[4];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            flag[i] = true;
            for (int j = 0; j < 4; j++) {
                if(flag[j]||arr[i]*10+arr[j]>23){
                    continue;
                }
                flag[j] = true;
                for (int k = 0; k < 4; k++) {
                    if(flag[k]||arr[k]>5){
                        continue;
                    }
                    flag[k] = true;
                    for (int l = 0; l < 4; l++) {
                        if(flag[l]||arr[i]*10+arr[j]>59){
                            continue;
                        }
                        list.add(arr[i] +""+ arr[j] +":"+ arr[k] + arr[l]);

                    }
                    flag[k] = false;
                }
                flag[j] = false;
            }
            flag[i] = false;
        }
        if(list.isEmpty()){
            return "";
        }
        list.sort(String::compareTo);
        return list.get(list.size()-1);
    }
}
