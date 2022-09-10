package com.qx.shuati.jingsai.doublce;

import com.qx.shuati.tree.TreeNode;

import java.util.Arrays;

/**
 * @author xuan
 * @date 2022/7/12 15:00
 */
public class No82 {

    public boolean evaluateTree(TreeNode root) {
        if(root.left==null||root.right==null){
            return root.val==1;
        }

        boolean f1 = evaluateTree(root.left);
        boolean f2 = evaluateTree(root.right);
        if(root.val==2){
            return f1||f2;
        }else {
            return f1&&f2;
        }
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int current = 0;
        int ans = 1;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        for (int i = 0; i < buses.length-1; i++) {
            int a = capacity;
            for (int j = current; j < passengers.length ; j++) {
                if((passengers[j]<=buses[i]&&a>0)){
                    if((j>0&&passengers[j]-passengers[j-1]!=1)||(j==0)){
                        ans = passengers[j]-1;
                    }
                    current++;
                    a--;
                }else {
                    break;
                }
            }
        }
        if(current==passengers.length){
            return buses[buses.length-1];
        }

        for (int i = current; i < passengers.length; i++) {
            if(passengers[i]<=buses[buses.length-1]&&capacity>0){
                if((i>0&&passengers[i]-passengers[i-1]!=1)||(i==0)){
                    ans = passengers[i]-1;
                }
                capacity--;
            }else {
                break;
            }
        }
        if(capacity>0&&Arrays.binarySearch(passengers,buses[buses.length-1])<0){

            return buses[buses.length-1];
        }
        return ans;
    }

//    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
//        long ans = 0;
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums1[i]-nums2[i];
//        }
//        int a1,a2,b1,b2;
//        long sum1 = 0,sum2=0;
//
//        a1 = sum1/
//        return ans;
//    }
}
