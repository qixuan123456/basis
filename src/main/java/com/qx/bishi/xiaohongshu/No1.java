package com.qx.bishi.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/8/28 16:32
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arg = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] nums = new int[arg[0]];
        for (int i = 0; i < arg[0]; i++) {
            for (int j = 0; j < arg[1]; j++) {
                nums[i]+=scanner.nextInt();
            }
        }
        int a = nums[arg[2]-1];
        int ans = 0;
        for (int i = 0; i < arg[0]; i++) {
            if(nums[i]>a){
                ans++;
            }
            if(nums[i]==a&&i<=arg[2]-1){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
