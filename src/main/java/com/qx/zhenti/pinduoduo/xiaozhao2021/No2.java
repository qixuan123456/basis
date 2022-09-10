package com.qx.zhenti.pinduoduo.xiaozhao2021;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/7/13 21:09
 */
public class No2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int[] nums = new int[26];
        for (int i = 0; i < N; i++) {
            nums[s1.charAt(i)-'a']++;
            nums[s2.charAt(i)-'a']--;
        }
        int l = 0,r=0;
        int ans = 0;
        while (l<26&&r<26){
            while(l<26&&nums[l]<=0){
                l++;
            }
            while (r<26&&nums[r]>=0){
                r++;
            }
            if(l>=26||r>=26){
                break;
            }
            nums[l]--;
            nums[r]++;
            ans+=Math.abs(l-r);
        }
        System.out.println(ans);
    }
}
