package day21.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/10/21
 * Time: 18:20
 */
public class No120 {
    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(2));
        lists.add(Arrays.asList(3,4));
        lists.add(Arrays.asList(6,5,7));
        lists.add(Arrays.asList(4,1,8,3));
        System.out.println(new No120().minimumTotal(lists));


    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int y = triangle.size();
        int x= triangle.get(y-1).size();
        int[][] res = new int[x][y];
        int i = 0;
        res[0][0] = triangle.get(0).get(0);
        for (List<Integer> list : triangle) {
            if(i==0){
                i++;
                continue;
            }
            int z = 0;
            for (Integer a : list) {
                if(z>0){
                    res[i][z] = a+Math.min(res[i-1][z],res[i-1][z-1]);
                    if(z==list.size()-1){
                        res[i][z] = a+res[i-1][z-1];
                    }
                } else {
                    res[i][z] = a+res[i-1][z];
                }
                z++;
            }
            i++;
        }
        int min = res[y-1][0];
        for (int j = 0; j < x; j++) {
            min = Math.min(min,res[y-1][j]);
        }
        return min;
    }
}
