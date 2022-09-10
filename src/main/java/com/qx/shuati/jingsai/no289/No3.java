package com.qx.shuati.jingsai.no289;

/**
 * @author xuan
 * @date 2022/4/18 15:09
 */
public class No3 {
    //超时了
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("0x2C".substring(2),16));
        //int[][] grid = {{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}};
        int[][] grid ={{1,5,2,4,25}};
        System.out.println(maxTrailingZeros(grid));
    }
    public static int maxTrailingZeros(int[][] grid) {
        int[][] f = {{-1,0},{1,0},{0,-1},{0,1}};
        int lenX = grid.length;
        int lenY = grid[0].length;
        int max = 0;

        for (int i = 0; i < lenX; i++) {
            for (int j = 0; j < lenY; j++) {
                int[][] sum2And5 = new int[4][2];
                int[] a = get2And5(grid[i][j]);
                for (int k = 0; k < 4; k++) {
                    int x = i+f[k][0];
                    int y = j+f[k][1];
                    while(x>=0&&x<lenX&&y>=0&&y<lenY){
                        int[] and5 = get2And5(grid[x][y]);
                        sum2And5[k][0] += and5[0];
                        sum2And5[k][1] += and5[1];
                        x = x+f[k][0];
                        y = y+f[k][1];
                    }
                }
                for (int k = 0; k < 3; k++) {
                    for (int l = k+1; l < 4; l++) {
                        int min = Math.min(sum2And5[k][0]+sum2And5[l][0]+a[0],sum2And5[k][1]+sum2And5[l][1]+a[1]);
                        if(min>max){
                            max = min;
                        }
                    }
                }
                if(lenX==1||lenY==1){
                    return max;
                }
            }
        }
        return max;
    }
    public static int[] get2And5(int n){
        int[] res = new int[2];
        while(n%2==0){
            res[0]++;
            n /= 2;
        }
        while (n%5==0){
            res[1]++;
            n /= 5;
        }
        return res;
    }
}
