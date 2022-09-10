package com.qx.shuati.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuan
 * @date 2022/5/4 15:40
 */
public class No1823 {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int start = 0;
        while(list.size()>1){
            int size = list.size();
            int count = k%size;
            int delete = (start+count)%size -1;
            if(delete==-1){
                delete = size-1;
            }
            list.remove(delete);
            start = delete;
        }
        return list.get(0)+1;
    }
}
