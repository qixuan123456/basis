package com.qx.day21.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

/**
 * @author xuan
 * @date 2022/6/9 15:59
 */
public class No497 {
    public TreeMap<Integer, int[]> map;
    public Random random;
    public int a = 0;

    public No497(int[][] rects) {
        map = new TreeMap<>();
        random = new Random();
        for (int i = 0; i < rects.length; i++) {
            map.put(a, rects[i]);
            a += (rects[i][3] - rects[i][1] + 1) * (rects[i][2] - rects[i][0] + 1);
        }
    }

    public int[] pick() {
        int count = random.nextInt(a);
        int[] temp = map.floorEntry(count).getValue();
        int x = temp[0]+random.nextInt(temp[2]-temp[0]+1);
        int y = temp[1]+random.nextInt(temp[3]-temp[1]+1);
        return new int[]{x,y};
    }
}
