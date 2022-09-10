package com.qx.zhenti.tencent;

import java.util.*;

/**
 * @author xuan
 * @date 2022/5/5 16:14
 */
public class ArrayAndString {

    /**
     * 最长回文字符串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        return "";
    }

    /**
     * 字符串转换整数
     *
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        char[] chars = s.trim().toCharArray();
        long ans = 0;
        int index = 0;
        int length = chars.length;
        boolean flag = true;
        if (length < 1) {
            return (int) ans;
        }
        if (chars[index] == '+') {
            index++;
        } else if (chars[0] == '-') {
            index++;
            flag = false;
        }
        while (index < length && Character.isDigit(chars[index])) {
            ans = ans * 10 + chars[index] - '0';
            index++;
            if (flag && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (!flag && -ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return flag ? (int) ans : (int) -ans;
    }

    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            len = Math.min(len, str.length());
        }
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 最接近的三数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        int s = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int newTarget = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == newTarget) {
                    return target;
                } else if (sum > newTarget) {
                    right--;
                } else {
                    left++;
                }
                int a = Math.abs(newTarget - sum);
                if (a < s) {
                    s = a;
                    ans = sum + nums[i];
                }
            }
        }
        return ans;
    }

    /**
     * 有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            switch (aChar) {
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    /**
     *删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>nums[left]){
                nums[++left] = nums[i];
            }
        }
        return left+1;
    }

    /**
     * 盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while (left<right){
            int current = Math.min(height[ left],height[right])*(right-left);
            ans = Math.max(current,ans);
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }

    /**
     * 字符串相乘
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if(num1.charAt(0)=='0'||num2.charAt(0)=='0'){
            return "0";
        }
        return multiply(num1.toCharArray(),num2.toCharArray());
    }

    public String multiply(char[] num1, char[] num2) {
        char[] res = new char[201];
        int index = 0;
        for (int i = num2.length-1; i >= 0; i--) {
            res = add(res,multiply(num1,num2[i],index++));
        }
        int offset = 0;
        for (int i = 0; i < res.length; i++) {
            if(res[i]=='0'){
                offset++;
            }else {
                break;
            }
        }
        if(offset==201){
            return "0";
        }
        return new String(res,offset,201-offset);
    }

    public char[] multiply(char[] num1, char num2,int index) {
        int carry = 0;
        int m1 = num2-'0';
        char[] res = new char[201];
        int c = 200-index;
        for (int i = num1.length-1; i >= 0; i--) {
            int m2 = num1[i]-'0';
            int m = m1*m2+carry;
            carry = m/10;
            res[c] = (char)((m%10)+'0');
            c--;
        }
        if(carry!=0){
            res[c] = (char)(carry+'0');
        }
        for (int i = 0; i < index; i++) {
            res[200-i] = '0';
        }
        return res;
    }

    public char[] add(char[] num1,char[] num2){
        char[] res = new char[201];
        int carry = 0;
        for (int i = 200; i >=0 ; i--) {
            int m1 = num1[i]==0? 0:num1[i]-'0';
            int m2 = num2[i]==0? 0:num2[i]-'0';
            int m = m1+m2+carry;
            carry = m/10;
            res[i] = (char) (m%10+'0');
        }
        return res;
    }

    /**
     * 反转字符串
     * @param s
     */
    public void reverseString(char[] s) {
        int length = s.length;

        for (int i = 0; i < length/2; i++) {
            char c = s[i];
            s[i] = s[length-i-1];
            s[length-i-1] = c;
        }
    }
}
