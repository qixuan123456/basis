package Day21.LeetCode;

import Day21.tool.Util;

import java.util.ArrayList;
import java.util.List;

public class No119 {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        int[][] aws = new int[rowIndex+1][rowIndex+1];
        for (int i = 0; i < rowIndex + 1; i++) {
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i){
                    aws[i][j] = 1;

                }else{
                    aws[i][j] = aws[i-1][j-1]+aws[i-1][j];
                }

            }
        }
        Util.print2Array(aws);
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(aws[rowIndex][i]);
        }
        return list;
    }
}
