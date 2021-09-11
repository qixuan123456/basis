package day21.leetcode;

public class No494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {

         return qwe(nums, target, 0, 0);
    }

    public static int qwe(int[] nums, int target, int cur, int res) {
        if (cur == nums.length) {
            if (0 == target) {
                res++;
            }
            return res;
        }
        res = qwe(nums, target - nums[cur], cur + 1, res);
        res = qwe(nums, target + nums[cur], cur + 1, res);
        return res;
    }
}
