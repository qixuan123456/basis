package day21.leetcode;

import day21.tool.Util;

/**
 * @author Xuan
 * Date: 2021/11/1
 * Time: 16:34
 */
public class No985 {

    public static void main(String[] args) {
        No985 no985 = new No985();
        int[] nums = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        Util.printArray(no985.sumEvenAfterQueries(nums,queries));
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        int[] ans = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]&1)==0){
                sum+=nums[i];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            if((nums[queries[i][1]]&1)==0){
                if((queries[i][0]&1)==1){
                    sum-=nums[queries[i][1]];
                    nums[queries[i][1]]+=queries[i][0];
                }else {
                    nums[queries[i][1]]+=queries[i][0];
                    sum+=queries[i][0];

                }
            }else {
                if((queries[i][0]&1)==1){
                    nums[queries[i][1]]+=queries[i][0];
                    sum+=nums[queries[i][1]];
                }else {
                    nums[queries[i][1]]+=queries[i][0];
                }
            }
            ans[i] = sum;
        }
        return ans;
    }
}
