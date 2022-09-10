package com.qx.zhenti.alibaba.bianchengti2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/3 16:05
 */
public class No10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < b.length; i++) {
            map.put(b[i],i);
        }
        int[] nums = new int[a.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(a[i]);
        }
        int max = 1;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                ans++;
                max = Math.max(ans,max);
            }else {
                ans = 1;
            }
        }
        System.out.println(N-max);
    }
}
