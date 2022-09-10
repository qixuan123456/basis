package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/5/7 14:44
 */
public class No1622 {

    public static final long MOD = 1000000007L;
    public List<Long> list;
    public List<Long> chars;
    public List<int[]> flag;
    public No1622() {
        this.list = new ArrayList<>();
        this.chars = new ArrayList<>();
        this.flag = new ArrayList<>();
    }

    public static void main(String[] args) {
        No1622 no1622 = new No1622();
        no1622.append(2);
        no1622.addAll(3);
        no1622.append(7);
        no1622.multAll(2);
        System.out.println(no1622.getIndex(0));
        no1622.addAll(3);
        no1622.append(10);
        no1622.multAll(2);
        System.out.println(no1622.getIndex(0));
        System.out.println(no1622.getIndex(1));
        System.out.println(no1622.getIndex(2));
    }

    public void append(int val) {
        list.add((long) val);
        flag.add(new int[]{chars.size(),chars.size()});
    }

    public void addAll(int inc) {
        chars.add(0L);
        chars.add((long) inc);
    }

    public void multAll(int m) {
        chars.add(1L);
        chars.add((long) m);
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) {
            return -1;
        }
        long res = list.get(idx);
        int[] f = flag.get(idx);
        if(f[0]==chars.size()){
            return (int) res;
        }
        for (int i = f[0]; i < chars.size(); i = i + 2) {
            if (chars.get(i) == 0) {
                res = (res + chars.get(i + 1)) % MOD;
            } else {
                res = (res * chars.get(i + 1)) % MOD;
            }
        }
        list.set(idx,res);
        f[0] = chars.size();
        return (int)res;
    }

}
