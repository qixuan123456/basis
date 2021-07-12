package Day21.LeetCode;

import java.util.TreeSet;

public class NO220 {
    public static void main(String[] args) {

        int[] nums = {-2147483648,2147483647};
        boolean flag = containsNearbyAlmostDuplicate(nums,1,1);
        System.out.println(flag);
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for(int i=0;i<nums.length;i++){
            Long a = set.ceiling((long)nums[i]-(long)t);
            if(a!=null&&a<=(long)nums[i]+(long)t)
                return true;
            set.add((long)nums[i]);
            if(i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
