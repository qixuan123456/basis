package day21.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No496 {
    public static void main(String[] args) {
        int[] nums1={4,1,2};
        int[] nums2={1,3,4,2};
        int[] a = nextGreaterElement(nums1,nums2);
        for (int value : a) {
            System.out.print(value+"\t");
        }
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            for (int j = i+1; j < nums2.length; j++) {
                if(nums2[j]>nums2[i]){
                    map.put(nums2[i],nums2[j]);
                    break;
                }
                if (j==nums2.length-1){
                    map.put(nums2[i],-1);
                }
            }
            if (i==nums2.length-1){
                map.put(nums2[i],-1);
            }
        }
        for (int i = 0; i < a.length; i++) {
            int d = nums1[i];
            a[i]=map.get(d);
        }
        return a;
    }
}
