package day21.leetcode;

/**
 * User: xuan
 * Date: 2021/9/24
 * Time: 18:02
 */
public class No2006 {
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 4};
        int k = 2;
        System.out.println(countKDifference(nums, k));
    }

    public static int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k)
                    res++;
            }
        }
        return res;
    }
}
