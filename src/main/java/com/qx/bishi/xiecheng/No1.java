package com.qx.bishi.xiecheng;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/30 19:40
 */
public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[q];
        for (int i = 0; i < q; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }
        for (int i = 0; i < q; i++) {
            int ans = even(nums[i]);
            System.out.println(ans);
        }
    }

    public static int even(int k){
        if(k%2==0){
            return k;
        }
        char[] chars = Integer.toString(k).toCharArray();
        for (int i = chars.length-1; i >= 0; i++) {
            if((chars[i]-'0')%2==0){
                char temp = chars[chars.length-1];
                chars[chars.length-1] = chars[i];
                chars[i] = temp;
                int ans = 0;
                for (int j = 0; j < chars.length; j++) {
                    ans=ans*10+(chars[j]-'0');
                }
                return ans;
            }
        }
        return -1;
    }
}
