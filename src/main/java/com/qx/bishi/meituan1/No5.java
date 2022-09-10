package com.qx.bishi.meituan1;

import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/13 16:59
 */
public class No5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(dfs(1,n,nums));

    }

    public static int dfs(int id, int n,int[] nums){
        if(id>n){
            return 0;
        }

        int sum = nums[id];
        sum+=Math.max(dfs(2*id,n,nums),dfs(2*id+1,n,nums));
        return sum;
    }
}
