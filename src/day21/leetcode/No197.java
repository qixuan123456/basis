package day21.leetcode;

import java.util.Arrays;

/**
 * @author Xuan
 * Date: 2021/11/26
 * Time: 10:35
 */
public class No197 {

    public static void main(String[] args) {

        int[] nums = {10,2};
        No197 no197 = new No197();
        System.out.println(no197.largestNumber(nums));
        String a = "";

    }

    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, (a, b) -> {
            String aa = a+b;
            String bb = b+a;
            return -aa.compareTo(bb);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (String value : s) {
            stringBuilder.append(value);
        }
        if(stringBuilder.charAt(0)=='0'){
            return "0";
        }
        return stringBuilder.toString();
    }
}
