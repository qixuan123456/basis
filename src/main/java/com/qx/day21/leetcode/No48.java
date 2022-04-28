package com.qx.day21.leetcode;


import com.qx.day21.tool.Util;

public class No48 {
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Util.print2Array(matrix);
        System.out.println();
        rotate(matrix);
        Util.print2Array(matrix);
    }
    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        int[][] newmatrix = new int[n][];
        for (int i = 0; i < n; i++) {
            newmatrix[i] = matrix[i].clone();
        }
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                matrix[i][j]=newmatrix[n-1-j][i];
            }
        }
    }
}
