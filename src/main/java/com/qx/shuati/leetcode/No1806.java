package com.qx.shuati.leetcode;


import com.qx.shuati.tool.Util;

/**
 * User: xuan
 * Date: 2021/10/14
 * Time: 20:18
 */
public class No1806 {

    public static void main(String[] args) {
        No1806 no1806 = new No1806();
        Util.printArray(no1806.memLeak(3,7));
    }
    public int[] memLeak(int memory1, int memory2) {
        int i =1;
        while (true){
            if(memory1>=memory2){
                if(memory1>=i){
                    memory1-=i;
                }else {
                    return new int[]{i,memory1,memory2};
                }
            }else {
                if(memory2>=i){
                    memory2-=i;
                }else {
                    return new int[]{i,memory1,memory2};
                }
            }
            i++;
        }
    }
}
