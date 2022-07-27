package com.qx.day21.leetcode;

import java.util.*;

/**
 * @author xuan
 * @date 2022/6/15 09:38
 */
public class No325 {


    public static void main(String[] args) {

        int[] nums = {-1,-1};
        System.out.println(new No325().countSmaller2(nums));
    }


    public int[] a;
    public int[] b;
    public int[] index;
    public int[] temp;

    public List<Integer> countSmaller1(int[] nums) {
        a = new int[nums.length];
        b = new int[nums.length];
        index = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
           index[i] = i;
        }
        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);

        List<Integer> list = new ArrayList<>();
        for (int j : b) {
            list.add(j);
        }
        return list;
    }

    public void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);

        for (int i = l; i <= r; i++) {
            a[i] = nums[i];
            temp[i] = index[i];
        }
        int left = l, right = mid + 1;

        for (int i = l; i <= r; i++) {
            if (right == r + 1) {
                index[i] = temp[left];
                nums[i] = a[left++];
            } else if (a[left] <= a[right] || left == mid + 1) {
                index[i] = temp[right];
                nums[i] = a[right++];
            } else {

                index[i] = temp[left];
                b[index[i]]+=(r - right + 1);
                nums[i] = a[left++];
            }
        }
    }


    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int[] sum = new int[set.size() + 1];
        List<Integer> list = new ArrayList<>(set);
        list.sort(Integer::compare);
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int a = 0;
            int index = Arrays.binarySearch(temp, nums[i])+1;
            int i1 = index;
            index = index - 1;
            while (index > 0) {
                a += sum[index];
                index -= (index & (-index));
            }
            ans.add(a);
            index = i1;
            while (index <= list.size()) {
                sum[index]++;
                index += (index & (-index));
            }
        }
        Collections.reverse(ans);
        return ans;
    }

}
