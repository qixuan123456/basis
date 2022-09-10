package com.qx.shuati.leetcode;

import java.util.HashMap;
import java.util.Map;

public class No73 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
        setZeroes(matrix);
        System.out.println("---------------------------------");
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        Map<Integer,Integer> x = new HashMap<>();
        Map<Integer,Integer> y = new HashMap<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    x.put(i,1);
                    y.put(j,1);
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            if (x.getOrDefault(i,0)==1){
                setX(matrix,i);
            }
        }

        for(int i=0;i<matrix[0].length;i++){
            if (y.getOrDefault(i,0)==1){
                setY(matrix,i);
            }
        }
    }
    public static void setX(int[][] matrix,int i){
        for(int j=0;j<matrix[0].length;j++){
            matrix[i][j]=0;
        }
    }
    public static void setY(int[][] matrix,int i){
        for(int j=0;j<matrix.length;j++){
            matrix[j][i]=0;
        }
    }

}
