package com.qx.day21.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xuan
 * @date 2022/6/16 14:45
 */
public class No874 {

    public static void main(String[] args) {
        int[] commands = {4,-1,3};
        int[][] obstacles = {};
        System.out.println(new No874().robotSim(commands,obstacles));

    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0,y = 0,f = 0;
        int ans = 0;
        Set<Long> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(((long)(obstacles[i][0]+30000)<<20)+obstacles[i][1]+30000);
        }
        for (int i = 0; i < commands.length; i++) {
            if(commands[i]==-2){
                f = (f+1)%4;
            }else if(commands[i] ==-1){
                f = (f+3)%4;
            }else {
                switch (f){
                    case 0 :
                        for (int j = 1; j <= commands[i]; j++) {
                            if(!set.contains(((long)(x+30000)<<20)+y+1+30000)){
                                y++;
                            }else {
                                break;
                            }
                        }
                        break;
                    case 1 :
                        for (int j = 1; j <= commands[i]; j++) {
                            if(!set.contains(((long)(x-1+30000)<<20)+y+30000)){
                                x--;
                            }else {
                                break;
                            }
                        }
                        break;
                    case 2 :
                        for (int j = 1; j <= commands[i]; j++) {
                            if(!set.contains(((long)(x+30000)<<20)+y-1+30000)){
                                y--;
                            }else {
                                break;
                            }
                        }
                        break;
                    case 3 :
                        for (int j = 1; j <= commands[i]; j++) {
                            if(!set.contains(((long)(x+1+30000)<<20)+y+30000)){
                                x++;
                            }else {
                                break;
                            }
                        }
                        break;
                }
                ans = Math.max(ans,x*x+y*y);
            }
        }
        return ans;
    }
}
