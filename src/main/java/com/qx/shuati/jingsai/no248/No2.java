package com.qx.shuati.jingsai.no248;

public class No2 {
    public static void main(String[] args) {
        int[] dist = {};
        int[] speed = {};
        System.out.println(eliminateMaximum(dist,speed));
    }
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int n = 0;
        while(true){
            int sums = 0;
            for (int i = 0; i < dist.length; i++) {
                if(dist[i]-speed[i]<=0){
                    sums++;
                    if(sums>1){
                        return n;
                    }
                }

            }
            break;

        }
        return 0;
    }
}
