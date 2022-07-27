package com.qx.shuati.tencent;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/5/5 16:15
 */
public class ArrayAndStringTest {
    ArrayAndString arrayAndString = new ArrayAndString();

    @Test
    public void longestPalindrome() {
    }

    @Test
    public void myAtoi() {
        System.out.println(arrayAndString.myAtoi(" -123sa"));
    }

    @Test
    public void longestCommonPrefix() {
        String[] strs = {"as","asdf","a"};
        System.out.println(arrayAndString.longestCommonPrefix(strs));
    }

    @Test
    public void threeSumClosest() {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(arrayAndString.threeSumClosest(nums,target));
    }

    @Test
    public void isValid() {
        String s = "()[]{}";
        System.out.println(arrayAndString.isValid(s));
    }

    @Test
    public void removeDuplicates() {
        int[] nums = {1,1,2,2,3,3};
        System.out.println(arrayAndString.removeDuplicates(nums));
    }

    @Test
    public void maxArea() {
        int[] heights = {1,23,352,3124,234,464,23,32,74,231};
        System.out.println(arrayAndString.maxArea(heights));
    }

    @Test
    public void multiply() {
        System.out.println(arrayAndString.multiply("9","9"));
    }

    @Test
    public void reverseString() {
        char[] chars = {'1','2','3','2','3','4','2','5','3'};
        arrayAndString.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
