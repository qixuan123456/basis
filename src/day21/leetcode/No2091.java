package day21.leetcode;

/**
 * @author Xuan
 * Date: 2021/11/29
 * Time: 15:31
 */
public class No2091 {

    public static void main(String[] args) {
        int[] nums = {2,10,7,5,4,1,8,6};
        No2091 no2091 = new No2091();
        System.out.println(no2091.minimumDeletions(nums));
    }

    public int minimumDeletions(int[] nums) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[min]<nums[i]){
                min = i;
            }
            if (nums[max]>nums[i]){
                max = i;
            }
        }
        if(max<min){
            int c= max;
            max = min;
            min = c;
        }
        return Math.min(max+1,Math.min(nums.length-min,min+1+nums.length-max));
    }
}
