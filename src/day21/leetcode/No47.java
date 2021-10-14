package day21.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: xuan
 * Date: 2021/10/11
 * Time: 15:53
 */
public class No47 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2};
        No47 no47 = new No47();
        System.out.println(no47.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, flag, lists, new ArrayList<>());
        return lists;
    }

    public void permute(int[] nums, boolean[] flag, List<List<Integer>> lists, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            System.out.println(list);
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1]) {
                continue;
            }
            if (!flag[i]) {
                list.add(nums[i]);
                flag[i] = true;
                permute(nums, flag, lists, list);
                list.remove(list.size() - 1);
                flag[i] = false;
            }
        }
    }
}
