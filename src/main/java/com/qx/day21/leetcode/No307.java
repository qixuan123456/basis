package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuan
 * @date 2022/6/6 19:29
 */
public class No307 {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-1});
        System.out.println(Arrays.toString(numArray.list));
        System.out.println(numArray.sumRange(0,16));
        numArray.update(0,1);
        System.out.println(numArray.sumRange(0,16));
        System.out.println(Arrays.toString(numArray.list));

    }
    static class NumArray {
        public int[] list;
        public int[] nums;
        public NumArray(int[] nums) {
            list = new int[2*nums.length];
            this.nums = nums;
            build(nums,list,0,nums.length-1,1);
        }

        public void build(int[] nums,int[] list,int l,int r,int id){
            if(l==r){
                list[id] = nums[l];
            }else {
                int mid = (l+r)>>1;
                build(nums,list,l,mid,2*id);
                build(nums,list,mid+1,r,2*id+1);
                list[id] = list[2*id]+list[2*id+1];
            }
        }

        public void update(int index, int val) {
            update(0,nums.length-1,index,val,1);
        }

        public void update(int l,int r,int index, int val,int id) {
            if(index>r||index<l){
                return;
            }
            if(l==r){
                list[id] = val;
                return;
            }
            int mid = (l+r)>>1;
            if(index<=mid){
                update(l,mid,index,val,2*id);
            }else {
                update(mid+1,r,index,val,2*id+1);
            }
            list[id] = list[2*id]+list[2*id+1];
        }

        public int sumRange(int left, int right) {
            return sumRange(left,right,0,nums.length-1,1);
        }
        public int sumRange(int left, int right,int l,int r,int id) {
            if(l>right||r<left){
                return 0;
            }
            if(left<=l&&right>=r){
                return list[id];
            }else {
                int mid = (l+r)>>1;
                int lValue = sumRange(left,right,l,mid,2*id);
                int rValue = sumRange(left,right,mid+1,r,2*id+1);
                return lValue+rValue;
            }
        }
    }
}
