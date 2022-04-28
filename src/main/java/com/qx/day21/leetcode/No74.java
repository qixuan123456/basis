package com.qx.day21.leetcode;

/**
 * User: Xuan
 * Date: 2021/10/28
 * Time: 14:41
 */
public class No74 {
    public static void main(String[] args) {
        No74 no74 = new No74();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(no74.searchMatrix(matrix,11));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int s = 0;
        int x = matrix.length-1;
        int i = (s+x)/2;
        while(s<x){
            if(matrix[i][0]<target){
                if(target<matrix[i+1][0]){
                    break;
                }
                s = i+1;
            }else if(matrix[i][0]>target){
                x = i-1;
            }else {
                return true;
            }
            i = (s+x)/2;
        }
        int l = 0;
        int r = matrix[0].length-1;
        int j = (l+r)/2;
        while (l<=r){
            if(matrix[i][j]<target){
                l = j+1;
            }else if(matrix[i][j]>target){
                r = j-1;
            }else {
                return true;
            }
            j = (l+r)/2;
        }
        return false;
    }
}
