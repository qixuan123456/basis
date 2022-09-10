package com.qx.shuati.leetcode;

/**
 * @author xuan
 * @date 2022/6/8 13:40
 */
public class No1147 {
    public static void main(String[] args) {
        System.out.println(longestDecomposition("elvtoelvto"));
    }

    public static int longestDecomposition(String text) {
        int start = 0, end = text.length() - 1;
        int length = 1;
        int ans = 0;
        while (start+length <= end-length+1) {
            String left = text.substring(start, start + length);
            String right = text.substring(end - length+1,end+1);
            if (left.equals(right)) {
                start = start + length;
                end = end - length;
                ans = ans+2;
                length = 1;
            } else {
                length++;
            }
        }
        if(start<=end){
            ans++;
        }

        return ans;
    }
}
