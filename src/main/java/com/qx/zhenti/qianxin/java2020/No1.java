package com.qx.zhenti.qianxin.java2020;

import java.util.*;

/**
 * @author xuan
 * @date 2022/8/25 17:05
 */
public class No1 {

    public static void main(String[] args) {

        solution("hello undo    redo world.");
        Scanner scanner = new Scanner(System.in);
        solution(scanner.nextLine());
    }


    public static void solution(String s) {
        List<String> list = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        String[] ss = s.split(" +");
        for (int i = 0; i < ss.length; i++) {
            if ("undo".equals(ss[i])) {
                list1.add(temp.toString());
                temp = new StringBuilder();
            } else if ("redo".equals(ss[i])) {
                if (temp.length() > 0) {
                    list.add(temp.toString());
                    temp = new StringBuilder();
                }
                list.add(list1.get(list1.size() - 1));
            } else {
                temp.append(ss[i]);
            }
        }
        list.add(temp.toString());
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                System.out.print(list.get(i));
            } else {
                System.out.print(" " + list.get(i));
            }
        }
    }
}
