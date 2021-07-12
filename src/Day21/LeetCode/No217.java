package Day21.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class No217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (set.size()==i){
                return true;
            }
        }
        return false;
    }
}
