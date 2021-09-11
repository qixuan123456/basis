package day21.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] == 0) {
                    lists.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right+1]){
                        right --;
                    }
                } else if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }


    //无去重版本
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> lists = new ArrayList<>();
//        Sum(nums,lists,0,0,new ArrayList<Integer>());
//        return lists;
//    }

    /**
     * 无去重版本
     *
     * @param nums  输入数组
     * @param lists 返回数组
     * @param addId 当前需要添加的数在nums中的下标
     * @param sum   当前list中的数字和
     * @param list  当前list
     */
    public static void Sum(int[] nums, List<List<Integer>> lists, int addId, int sum, List<Integer> list) {
        if (list.size() == 3) {
            if (sum == 0) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        if (addId == nums.length) {
            return;
        }
        list.add(nums[addId]);
        sum += nums[addId];
        //cur++;
        addId++;
        Sum(nums, lists, addId, sum, list);
        list.remove(list.size() - 1);
        sum -= nums[addId - 1];
        Sum(nums, lists, addId, sum, list);
    }
}
