package Test;

import java.util.Arrays;

public class aaa {
    public static void main(String[] args) {
        int[] nums = {-1,-2,0,1,1,1};
        int length = 6;
        System.out.println(getMax(length,nums));
    }
    public static int getMax(int length,int[] nums){
        int max = 0;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = length-1; i >=0 ; i--) {
            sum += nums[i];
            if(sum>=0){
                max++;
            }
            else {
                return max;
            }
        }
        return max;
    }
}
