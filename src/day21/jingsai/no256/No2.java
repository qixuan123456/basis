package day21.jingsai.no256;

import java.util.Arrays;
import java.util.Comparator;

public class No2 {
    public static void main(String[] args) {
        String[] nums = {"2","21","12","1"};
        System.out.println(kthLargestNumber(nums,3));
    }
    public static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()>o2.length()){
                    return 1;
                }else if(o1.length()<o2.length()){
                    return -1;
                }else return Integer.compare(o1.compareTo(o2), 0);
            }
        });
        return nums[nums.length-k];
    }
}
