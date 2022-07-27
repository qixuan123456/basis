package com.qx.day21.jingsai;

import org.junit.Test;

/**
 * @author xuan
 * @date 2022/5/3 20:21
 */
public class No291Test {
    public No291 no291 = new No291();
    @Test
    public void no1(){
        System.out.println(no291.removeDigit("1231",'1'));
    }
    @Test
    public void no2(){
        System.out.println(no291.minimumCardPickup(new int[]{1,2,3}));
    }
    @Test
    public void no3(){
        System.out.println(no291.countDistinct(new int[]{1,2,3,4}, 4, 1));
    }
}
