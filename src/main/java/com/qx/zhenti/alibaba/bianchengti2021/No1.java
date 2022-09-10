package com.qx.zhenti.alibaba.bianchengti2021;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/2 20:35
 */
public class No1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] nums = new int[n][n];
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            for (int j = 0; j < s.length; j++) {
                nums[j][0] = Integer.parseInt(s[j]);
            }
            line = scanner.nextLine();
            s = line.split(" ");
            for (int j = 0; j < s.length; j++) {
                nums[j][1] = Integer.parseInt(s[j]);
            }
            Arrays.sort(nums,(a,b)->{
                if(a[0]-b[0]==0){
                    return a[1]-b[1];
                }else {
                    return a[0]-b[0];
                }
            });


            System.out.println(getLength(nums));
        }
    }


    public static int getLength(int[][] nums){

//        int[][] temp = new int[nums.length][2];
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(max==0||(nums[i][0]>temp[max-1][0]&&nums[i][1]>temp[max-1][1])){
//                temp[max] = nums[i];
//                max++;
//            }else {
//                int left = 0,right = max-1;
//                while (left<right){
//                    int mid = (left+right)>>1;
//                    if(temp[mid][0]<nums[i][0]&&temp[mid][1]<nums[i][1]){
//                        left = mid;
//                    }else if(temp[mid][0]==nums[i][0]&&temp[mid][1]<nums[i][1]){
//                        right = mid;
//                    }else if(temp[mid][0]==nums[i][0]&&temp[mid][1]>nums[i][1]){
//                        rig
//                    }else {
//
//                    }
//                }
//            }
//        }
        return 1;
    }
}
