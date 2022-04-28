package com.qx.day23;

public class xulie {
    public static void main(String[] args) {
        //自己写输入Scanner
        int[] nums = {1,-1,2,-2};


        int[] res= jiejue(nums);
        for (int i = 0; i < res.length; i++) {
            if(i==0) {
                System.out.print(res[i]);
            }
            else {
                System.out.print(" "+res[i]);
            }
        }
    }
    public static int[] jiejue(int[] nums){
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(i%2==1){
                res[i] = nums[i-1]-nums[i];
            }else {
                res[i] = nums[i]-nums[i-1];
            }
        }
        return res;
    }
}
