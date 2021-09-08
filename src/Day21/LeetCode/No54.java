package Day21.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        List<Integer> list = spiralOrder(matrix);
        list.forEach(System.out::print);
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int flag = 0;
        int i = 0;
        int j = 0;
        int top = 1;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        for (int n = 0; n < matrix.length * matrix[0].length; n++) {
            list.add(matrix[i][j]);
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
        return list;
    }
}
