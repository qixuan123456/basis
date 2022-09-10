package com.qx.bishi.meituan2;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * @author xuan
 * @date 2022/8/27 16:10
 */
public class No2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = scanner.nextInt();
        }
        int[] ans = new int[n];
        int index = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = m-1; i >= 0; i--) {
            if(!set.contains(nums[i])){
                ans[index++] = nums[i];
                set.add(nums[i]);
            }
        }

        for (int i = 1; i <= n; i++) {
            if(!set.contains(i)){
                ans[index++] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if(i==0){
                System.out.print(ans[i]);
            }else{
                System.out.print(" "+ans[i]);
            }
        }

    }
}
