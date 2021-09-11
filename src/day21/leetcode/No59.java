package day21.leetcode;

import day21.tool.Util;


public class No59 {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(5);
        Util.print2Array(matrix);
    }
    public static int[][] generateMatrix(int n) {
        int flag = 0;
        int i = 0;
        int j = 0;
        int top = 1;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int[][] matrix = new int[n][n];
        for (int z = 1; z <= n*n; z++) {
            matrix[i][j] = z;
            switch (flag){
                case 0:{
                    if(j==right){
                        flag = 1;
                        right--;
                        i++;
                        break;
                    }
                    j++;
                    break;
                }
                case 1:{
                    if(i==down){
                        flag = 2;
                        down--;
                        j--;
                        break;
                    }
                    i++;
                    break;
                }
                case 2:{
                    if(j==left){
                        flag = 3;
                        left++;
                        i--;
                        break;
                    }
                    j--;
                    break;
                }
                case 3:{
                    if(i==top){
                        flag = 0;
                        top++;
                        j++;
                        break;
                    }
                    i--;
                }
            }
        }
        return matrix;
    }
}
