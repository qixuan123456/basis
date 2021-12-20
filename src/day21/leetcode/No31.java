package day21.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/12/17
 * Time: 14:47
 */
public class No31 {

    public static void main(String[] args) {

    }

    public void nextPermutation(int[] nums) {
        if(nums.length==1){
            return;
        }
        for (int i = nums.length-2; i > -1; i--) {
            int count = nums.length-1;
            while (count>i&&nums[count]<=nums[i]){
                count--;
            }
            if(count>i){
                int a = nums[count];
                nums[count] = nums[i];
                nums[i] = a;
                Arrays.sort(nums,i+1,nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}
