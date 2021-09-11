package day21.leetcode;

import java.util.Arrays;

public class No347 {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        int k =2;
        int[] a = topKFrequent(nums,k);
        for (int value : a) {
            System.out.println(value);
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        int[] a = new int[k];
        if(k==0){
            return a;
        }
        Arrays.sort(nums);
        int j=0;
        a[0]=nums[0];
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=a[j]){
                j++;
                a[j]=nums[i];
            }
            if(j+1>=k)
                return a;
        }
        return a;
    }
}
