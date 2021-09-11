package day21.leetcode;

public class Jianzhi59_1 {
    public static void main(String[] args) {
        int[] nums = {1,-1};
        int k=1;
        int[] a = maxSlidingWindow(nums,k);

        for (int b:a){
            System.out.println(b);
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0){
            return new int[0];
        }
        int[] a = new int[nums.length-k+1];
        for (int i = 0; i < a.length; i++) {
            a[i]=nums[i];
            for (int j = 0; j < k; j++) {
                if(a[i]<nums[i+j]){
                    a[i]=nums[i+j];
                }
            }
        }
        return a;
    }
}
