package com.qx.day21.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/6/27 10:08
 */
public class No522 {

    public int findLUSlength(String[] strs) {
        String ansString = "";
        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {

                if(i!=j&&check(strs[i],strs[j])){
                    flag = false;
                    break;
                }
            }
            if(flag){
                ans = Math.max(ans,strs[i].length());
            }
        }
        return ans;
    }

    public boolean check(String s1,String s2){

        int l1 = s1.length(),l2 = s2.length();
        int count1 = 0,count2 = 0;

        while(count1<l1&&count2<l2){
            if(s1.charAt(count1)==s2.charAt(count2)){
                count1++;
            }
            count2++;
        }
        return count1==l1;
    }
}
