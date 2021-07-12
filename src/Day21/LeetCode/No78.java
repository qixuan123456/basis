package Day21.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> lists = subsets(nums);
        System.out.println(lists.toString());

    }
    public static List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        double a = Math.pow(2,len);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0;i<a;i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                int c = (i >> j)&1;
                if(c==1){
                    list.add(nums[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
