package com.qx.day21.jingsai;

import java.util.*;

/**
 * @author xuan
 * @date 2022/6/5 16:08
 */
public class No296 {


    public int minMaxGame(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] newNums = new int[nums.length / 2];
        for (int i = 0; i < newNums.length; i++) {
            if ((i & 1) == 1) {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            }
        }
        return minMaxGame(newNums);
    }

    public int partitionArray(int[] nums, int k) {
        if (nums.length < 1) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 1;
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[left] > k) {
                ans++;
                left = i;
            }
        }
        return ans;
    }

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] operation : operations) {
            map.put(operation[1], map.remove(operation[0]));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nums[entry.getValue()] = entry.getKey();
        }
        return nums;
    }

    static class TextEditor {
        public StringBuilder sb;
        public int index;
        public TextEditor() {
            sb = new StringBuilder();
            index = 0;
        }

        public void addText(String text) {
            sb.insert(index,text);
            index += text.length();
        }

        public int deleteText(int k) {
            if(index<k){
                int result = index;
                sb = new StringBuilder(sb.substring(index));
                index = 0;
                return result;
            }else {
                sb.delete(index-k,index);
                index -= k;
                return k;
            }
        }

        public String cursorLeft(int k) {
            index = Math.max(0,index-k);
            int min = Math.min(10,index);
            return sb.substring(index-min,index);
        }

        public String cursorRight(int k) {
            index = Math.min(sb.length(),index+k);
            int min = Math.min(10,index);
            return sb.substring(index-min,index);
        }
    }
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.addText("leetcode");
        textEditor.deleteText(4);
        textEditor.addText("practice");
        textEditor.cursorRight(3);
        textEditor.cursorLeft(8);
        textEditor.deleteText(10);
        textEditor.cursorLeft(2);
        System.out.println(textEditor.cursorRight(6));
    }
}
