package com.qx.shuati.jingsai;

/**
 * @author xuan
 * @date 2022/7/31 12:16
 */
public class No304 {














//    public int minimumOperations(int[] nums) {
//        Arrays.sort(nums);
//        int n = 0;
//        int ans = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]-n!=0){
//                n = nums[i];
//                ans++;
//            }
//        }
//        return ans;
//    }
//
//    public int maximumGroups(int[] grades) {
//        int ans = 1;
//
//        while (ans*(ans+1)/2<=grades.length){
//            ans++;
//        }
//        return ans;
//    }
//
//    int ans = -1;
//    boolean[] flags;
//    public int longestCycle(int[] edges) {
//        flags = new boolean[edges.length];
//        for (int i = 0; i < flags.length; i++) {
//            if(!flags[i]){
//                dfs(edges,i,new int[edges.length],1);
//            }
//        }
//        return ans;
//    }
//
//    public void dfs(int[] edges,int index,int[] level,int cLevel){
//        if(level[index]!=0){
//            ans = Math.max(cLevel-level[index],ans);
//            return;
//        }
//        if(flags[index]){
//            return;
//        }
//        flags[index] = true;
//        level[index] = cLevel;
//
//        if(edges[index]!=-1){
//            dfs(edges,edges[index],level,cLevel+1);
//        }
//    }




















}
