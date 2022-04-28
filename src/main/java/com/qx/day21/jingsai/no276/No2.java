package com.qx.day21.jingsai.no276;

/**
 * @author Xuan
 * Date: 2022/1/18
 * Time: 19:45
 */
public class No2 {

    public static void main(String[] args) {
        //System.out.println(new No2().minMoves(19,2));
        int n = 40961;
        long seedEpoch = 4096;
        long randomXForkLag = 128;
        seedEpoch -= 1;
        for (int i = 0; i < 4096; i++) {
            long seedHeight = n&~seedEpoch;
            long preSeedHeight = seedHeight -seedEpoch -1;
            long h = preSeedHeight - randomXForkLag;
            System.out.println("seedEpoch: "+seedEpoch);
            System.out.println("preSeedHeight: "+preSeedHeight);
            System.out.println("h: "+h);
            System.out.println("-------------");
            n++;
        }


    }

    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        int i = 1;
        while (i * 2 <= target) {
            i = i * 2;
            count++;
        }
        if(count<=maxDoubles-1){
            return count+target-i;
        }else {
            int s = count-maxDoubles;
            return (int) (Math.pow(2,s)-1+maxDoubles+target-i);
        }
    }
}
