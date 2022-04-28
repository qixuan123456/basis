package com.qx.day21.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Xuan
 * Date: 2021/11/8
 * Time: 15:35
 */
public class No299 {
    public static void main(String[] args) {
        No299 no299 = new No299();
        System.out.println(no299.getHint("1807","1780"));
    }

    public String getHint(String secret, String guess) {
        int A= 0,B=0;
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s==g){
                A++;
            }else {
                list1.add(s-'0');
                list2.add(g-'0');
            }
        }
        for (Integer integer : list2) {
            if (list1.contains(integer)) {
                list1.remove(integer);
                B++;
            }
        }

        return A+"A"+B+"B";
    }
}
