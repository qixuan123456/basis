package day21.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xuan
 * Date: 2021/11/24
 * Time: 15:13
 */
public class No423 {

    public static void main(String[] args) {

    }


    public String originalDigits(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int[] res = new int[10];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        res[0] = map.getOrDefault('z',0);
        res[6] = map.getOrDefault('x',0);
        res[2] = map.getOrDefault('w',0);
        res[4] = map.getOrDefault('u',0);
        res[8] = map.getOrDefault('g',0);


        res[3] = map.getOrDefault('h',0)-res[8];
        res[5] = map.getOrDefault('f',0)-res[4];
        res[7] = map.getOrDefault('s',0)-res[6];

        res[9] = map.getOrDefault('i',0)-res[5]-res[6]-res[8];
        res[1] = map.getOrDefault('n',0)-res[7]-res[9]*2;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < res[i]; j++) {
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }
}
