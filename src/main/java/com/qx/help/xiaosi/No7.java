package com.qx.help.xiaosi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xuan
 * @date 2022/9/6 20:15
 */
public class No7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nums[0];
        int k = nums[1];
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp+= arr[i];
            if(temp==k){
                System.out.println(k);
                break;
            }else if(temp>k){
                System.out.println(k-1);
                break;
            }
        }
    }
}
