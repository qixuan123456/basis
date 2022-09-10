package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/7/1 13:26
 */
public class No241 {

    public static void main(String[] args) {
        System.out.println(new No241().diffWaysToCompute("0"));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> digital = new ArrayList<>();
        List<Character> operator = new ArrayList<>();
        char[] chars = expression.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                operator.add(chars[i]);
                digital.add(num);
                num = 0;
            } else {
                num = num * 10 + (chars[i] - '0');
            }
        }

        digital.add(num);


        ArrayList<Integer>[][] lists = new ArrayList[digital.size()][digital.size()];

        for (int i = 0; i < digital.size(); i++) {
            for (int j = 0; j < digital.size(); j++) {
                lists[i][j] = new ArrayList();
                if (i == j) {
                    lists[i][j].add(digital.get(i));
                }
            }
        }

        for (int i = 1; i < digital.size(); i++) {
            for (int j = 0; j < digital.size() - i; j++) {
                lists[j][j + i] = getList(lists, j, j + i, operator);
            }
        }

        return lists[0][digital.size() - 1];
    }

    private ArrayList<Integer> getList(ArrayList<Integer>[][] lists, int start, int end, List<Character> operator) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = start; i < end; i++) {
            List<Integer> list1 = lists[start][i];
            List<Integer> list2 = lists[i + 1][end];
            for (int j = 0; j < list1.size(); j++) {
                int a = list1.get(j);
                for (int k = 0; k < list2.size(); k++) {
                    if (operator.get(i) == '*') {
                        res.add(a * list2.get(k));
                    } else if (operator.get(i) == '-') {
                        res.add(a - list2.get(k));
                    } else {
                        res.add(a + list2.get(k));
                    }
                }
            }
        }
        return res;

    }
}
