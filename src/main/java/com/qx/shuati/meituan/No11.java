package com.qx.shuati.meituan;

import com.qx.shuati.tencent.ArrayAndString;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/5/11 16:30
 */
public class No11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] nums = new int[7];
        for (int i = 0; i < 7; i++) {
            nums[i] = sc.nextInt();
        }
        int[][] a = new int[3][2];
        for (int i = 0; i < 3; i++) {
            a[i][1] = nums[i];
            a[i][0] = nums[i+4];
        }
        Arrays.sort(a,(a1,a2)-> a2[0]-a1[0]);
        long ans = 0;
        for (int i = 0; i < 3&&nums[3]>0; i++) {
            if(a[i][1]>=nums[3]){
                ans+=((long) a[i][0] *nums[3]);
                break;
            }else {
                ans+=((long) a[i][0] *a[i][1]);
                nums[3]-=a[i][1];
            }
        }
        System.out.println(ans);
    }
}
