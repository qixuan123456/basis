package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/8/4 21:04
 */
public class No76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
    public static String minWindow(String s, String t) {
        String ans = "";
        int length = Integer.MAX_VALUE;
        int[] temp = new int[256];
        int[] target = new int[256];
        int slength = s.length();
        int tlength = t.length();
        int l = 0,r = tlength-1;
        for(int i=0;i<tlength;i++){
            int c = t.charAt(i);
            target[c]++;
        }
        for(int i=0;i<tlength;i++){
            char c = s.charAt(i);
            temp[c]++;
        }

        while(l<slength-tlength&&l<=r&&r<slength){
            if(compare(target,temp)){
                temp[s.charAt(l)]--;
                if(r-l+1<length){
                    ans = s.substring(l,r+1);
                    length = r-l+1;
                }
                l++;
            }else{
                r++;
                if(r==slength){
                    break;
                }
                temp[s.charAt(r)]++;
            }
        }
        return ans;
    }

    public static boolean compare(int[] target,int[] temp){
        for(int i=0;i<target.length;i++){
            if(target[i]!=0&&target[i]>temp[i]){
                return false;
            }
        }
        return true;
    }
}
