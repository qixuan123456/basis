package day21.leetcode;

public class No713 {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums,k));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int s = nums[i];
            for (int j = i; j < nums.length; j++) {
                if(j==i){
                    s = nums[i];
                }else {
                    s *= nums[j];
                }
                if(s<k){
                    max ++;
                }else{
                    break;
                }
            }
        }
        return max;
    }
}
