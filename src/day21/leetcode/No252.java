package day21.leetcode;

import day21.tool.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * User: xuan
 * Date: 2021/10/9
 * Time: 09:51
 */
public class No252 {
    public static void main(String[] args) {
        SummaryRanges s = new SummaryRanges();
        s.addNum(1);
        //Util.print2Array(s.getIntervals());
        s.addNum(2);
        //Util.print2Array(s.getIntervals());
        s.addNum(5);
        //Util.print2Array(s.getIntervals());
        s.addNum(7);
        //Util.print2Array(s.getIntervals());
        s.addNum(8);
        //Util.print2Array(s.getIntervals());
        s.addNum(6);
        Util.print2Array(s.getIntervals());
    }

}

class SummaryRanges {
    List<Integer> list;
    int[][] res;

    public SummaryRanges() {
        this.list = new ArrayList<>();
    }

    public void addNum(int val) {
        list.add(val);
        res = new int[list.size()][2];
        //list.sort(Comparator.comparingInt(Integer::intValue));
        list.sort(Integer::compareTo);
    }

    public int[][] getIntervals() {
        res[0][0] = res[0][1] = list.get(0);
        int flag = 0;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)>res[flag][1]+1){
                flag++;
                res[flag][0] = res[flag][1] = list.get(i);
            }else if(list.get(i)==res[flag][1]+1){
                res[flag][1] = res[flag][1]+1;
            }
        }
        return Arrays.copyOf(res,flag+1);
    }
}









