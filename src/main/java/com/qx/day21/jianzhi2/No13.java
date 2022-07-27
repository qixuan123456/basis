package com.qx.day21.jianzhi2;

/**
 * @author xuan
 * @date 2022/7/1 14:24
 */
public class No13 {

    int ans = 0;
    int m,n,k;
    int[][] f = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        dfs(new boolean[m][n],0,0);
        return ans;
    }
    public void dfs(boolean[][] flag,int x,int y){
        if(x>=m||x<0||y>=n||y<0||flag[x][y]||getInt(x)+getInt(y)>k){
            return;
        }
        flag[x][y] = true;
        ans++;
        for (int i = 0; i < 4; i++) {
            dfs(flag,x+f[i][0],y+f[i][1]);
        }
    }

    public int getInt( int x){
        int res = 0;
        while (x>0){
            res+=(x%10);
            x /= 10;
        }
        return res;
    }
}
