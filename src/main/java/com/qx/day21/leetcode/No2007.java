package com.qx.day21.leetcode;


import com.qx.day21.tool.Util;

import java.util.Arrays;


/**
 * User: xuan
 * Date: 2021/9/24
 * Time: 18:46
 */
public class No2007 {
    public static void main(String[] args) {
        int[] changed =new int[]{1,3,4,2,6,8};
        int[] a= findOriginalArray(changed);
        Util.printArray(a);
    }

    public static int[] findOriginalArray(int[] changed) {
        if(changed.length%2==1){
            return new int[]{};
        }
        Arrays.sort(changed);
        int[] res = new int[changed.length/2];
        int k = 0;
        for (int i = 0; i < changed.length-1; i++) {
            if(changed[i]==-1){
                continue;
            }
            for (int j = i+1; j < changed.length; j++) {
                if(changed[j]==-1){
                    continue;
                }
                if(changed[i]*2==changed[j]){
                    res[k]=changed[i];
                    changed[j]=-1;
                    changed[i]=-1;
                    k++;
                    break;
                }
            }
        }
        if(k==res.length){
            return res;
        }else {
            return new int[]{};
        }
    }
}
