package day21.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: xuan
 * Date: 2021/10/8
 * Time: 15:06
 */
public class No187 {

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        No187 no187 = new No187();
        System.out.println(no187.findRepeatedDnaSequences(s));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()<10){
            return res;
        }
        Map<String ,Integer> map = new HashMap<>();
        char[] ss = s.toCharArray();

        for (int i = 0; i < ss.length-9; i++) {
            String a = new String(ss,i,10);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        for (Map.Entry<String,Integer> a: map.entrySet()){
            if(a.getValue()>1){
                res.add(a.getKey());
            }
        }
        return res;
    }
}
