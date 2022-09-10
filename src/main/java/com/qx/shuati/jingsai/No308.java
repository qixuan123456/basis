package com.qx.shuati.jingsai;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author xuan
 * @date 2022/8/29 13:24
 */
public class No308 {

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums);

        for (int i = 0; i < m; i++) {
            int current = 0;
            for (int j = 0; j < n; j++) {
                current += nums[j];
                if(current<=queries[i]){
                    ans[i] = j+1;
                }else {
                    break;
                }
            }
        }
        return ans;
    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='*'){
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int M = 0;
        int P = 0;
        int G = 0;
        int[] add = new int[3];

        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                char c = garbage[i].charAt(j);
                if(c=='M'){
                    M++;
                    add[0] = i;
                }else if(c =='P'){
                    P++;
                    add[1] = i;
                }else {
                    G++;
                    add[2] = i;
                }
            }
        }

        int[] ans = new int[garbage.length];
        for (int i = 1; i < garbage.length; i++) {
            ans[i] = ans[i-1]+travel[i-1];
        }
        return M+P+G+ans[add[0]]+ans[add[1]]+ans[add[2]];
    }

    public static void main(String[] args) {
        new No308().buildMatrix(3,new int[][]{{1,2},{3,2}},new int[][]{{2,1},{3,2}});
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] row = build(k,rowConditions);
        int[] col = build(k,colConditions);

        if(row==null||col==null){
            return new int[k][k];
        }
        int[][] ans = new int[k][k];
        for (int i = 1; i <= k; i++) {
            ans[row[i]-1][col[i]-1] = i;
        }
        return ans;
    }

    public int[] build(int k,int[][] conditions){
        int[] res = IntStream.range(0,k+1).toArray();
        for (int j = 0; j < conditions.length; j++) {
            for (int i = 0; i < conditions.length; i++) {
                if(res[conditions[i][0]]>res[conditions[i][1]]){
                    int a = res[conditions[i][0]];
                    res[conditions[i][0]] = res[conditions[i][1]];
                    res[conditions[i][1]] = a;
                }
            }
        }


        for (int i = 0; i < conditions.length; i++) {
            if(res[conditions[i][0]]>res[conditions[i][1]]){
                return null;
            }
        }
        return res;
    }
}
