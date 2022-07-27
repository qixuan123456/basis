package com.qx.day21.jingsai;

import org.junit.Test;

/**
 * @author xuan
 * @date 2022/4/24 18:06
 */

public class No290Test {

    public No290 no290 = new No290();
    @Test
    public void no1(){

    }

    @Test
    public void no2(){

    }

    @Test
    public void no3(){
        int[][] rectangles = {{1,2},{2,3},{2,5}}, points = {{2,1},{1,4}};
        no290.countRectangles(rectangles,points);
    }

    @Test
    public void no4(){

    }

    @Test
    public void countLatticePoints() {
        int[][] ci = {{2,2,1}};
        System.out.println(no290.countLatticePoints(ci));
    }
}
