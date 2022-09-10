package com.qx.shuati.jingsai;

import com.qx.shuati.tree.TreeNode;

/**
 * @author xuan
 * @date 2022/5/8 19:10
 */
public class No292 {

    public String largestGoodInteger(String num) {
        char c = 0;
        char[] chars = num.toCharArray();
        for (int i = 0; i < chars.length - 2; i++) {
            if (chars[i] == chars[i + 1] && chars[i] == chars[i + 2]) {
                if (chars[i] > c) {
                    c = chars[i];
                }
            }
        }

        if (c != 0) {
            return new String(new char[]{c, c, c});
        }
        return "";
    }

    public int averageOfSubtree(TreeNode root) {
        return dfs(root)[0];
    }

    public int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, 0};
        }
        int[] res = new int[3];
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        res[0] = l[0] + r[0];
        res[1] = l[1] + r[1] + root.val;
        res[2] = l[2] + r[2] + 1;
        if (res[1] / res[2] == root.val) {
            res[0]++;
        }
        return res;
    }

    public int mod = 1000000007;

    public int countTexts(String pressedKeys) {
        long ans = 1;
        int start = 0, end = 0;
        for (int i = 0; i < pressedKeys.length() - 1; i++) {
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i + 1)) {
                end++;
            } else {

                ans = (ans * getAmount(end - start + 1, getFlag(pressedKeys.charAt(i)))) % mod;
                start = i + 1;
                end = i + 1;
            }
        }
        return (int) ((ans * getAmount(end - start + 1, getFlag(pressedKeys.charAt(end)))) % mod);
    }

    public int getFlag(char c) {
        if (c == '7' || c == '9') {
            return 4;
        } else {
            return 3;
        }
    }

    public int getAmount(int n, int flag) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= flag && i >= j; j++) {
                dp[i] = (dp[i - j] + dp[i]) % mod;
            }
        }
        return dp[n];
    }


    public int[][] f = {{0,1},{1,0}};
    public int m,n;
    //会超时
    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if((m+n-1)%2==1){
            return false;
        }
        boolean[][] flag = new boolean[m][n];
        return dfs(grid,flag,0,0,0,0);
    }

    public boolean dfs(char[][] grid,boolean[][] flag,int x,int y,int a,int b){
        if(grid[x][y]=='('){
            a++;
        }else{
            b++;
        }
        if((a-b)<0||a>(m+n)/2||b>(m+n)/2){
            return false;
        }
        if(x==m-1&&y==n-1&&(a-b)==0){
            return true;
        }
        flag[x][y] = true;
        if((x+1<m&&!flag[x+1][y]&&dfs(grid,flag,x+1,y,a,b)) ||(y+1<n&&!flag[x][y+1]&&dfs(grid,flag,x,y+1,a,b))){
            return true;
        }
        flag[x][y] = false;
        return false;
    }
}
