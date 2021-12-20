package day21.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Xuan
 * Date: 2021/12/19
 * Time: 14:28
 */
public class No997 {


    public static void main(String[] args) {

    int n = 2;
    int[][] trust = new int[][]{
            {1,2}
    };
        System.out.println(findJudge(n,trust));
    }
    public  static int findJudge(int n, int[][] trust) {
        if(n==1){
            return 1;
        }
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }

        for (int i = 0; i < trust.length; i++) {
            set.remove(trust[i][0]);
            map.put(trust[i][1],map.getOrDefault(trust[i][1],0)+1);
        }
        if(set.size()!=1){
            return -1;
        }
        for (Integer a : set) {
            if(map.getOrDefault(a,-1) != n-1){
                return -1;
            }else {
                return a;
            }
        }
        return -1;
    }

}
