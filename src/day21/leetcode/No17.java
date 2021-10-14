package day21.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/10/12
 * Time: 16:10
 */
public class No17 {
    public static void main(String[] args) {
        String digits = "";
        No17 no17 = new No17();
        System.out.println(no17.letterCombinations(digits));
    }

    List<String> a = Arrays.asList("abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        combination(digits,0,list);
        return list;
    }

    public void combination(String digits, int count, List<String> list){
        if(count>=digits.length()){
            list.add(sb.toString());
            return;
        }
        String cur = a.get(digits.charAt(count)-'2');
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            combination(digits,count+1,list);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
