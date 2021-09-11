package day16.leetcode;

import java.util.ArrayList;
import java.util.List;

public class leet448 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<10;i++){
            list.add(i);
        }
        list.remove((Integer)10);
        for (Integer a:list) {
            System.out.println(a);

        }
    }
}
