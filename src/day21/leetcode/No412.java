package day21.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No412 {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
    }
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String a = Integer.toString(i);
            if(i%3==0){
                a = "Fizz";
                if(i%5==0){
                    a = "FizzBuzz";
                }
            }else if (i%5==0){
                a = "Buzz";
            }
            list.add(a);
        }
        return list;
    }
}
