package com.qx.day21.jingsai;

import com.qx.day21.list.ListBuild;
import com.qx.day21.list.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @date 2022/7/3 10:31
 */
public class No300 {


    public static String decodeMessage(String key, String message) {
        Map<Character,Character> map = new HashMap<>();
        char c = 'a';
        for (int i = 0; i < key.length(); i++) {
            char a = key.charAt(i);
            if(a!=' '&&map.get(a)==null){
                map.put(a,c);
                c++;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char a = message.charAt(i);
            if(a!=' '){
                a = map.get(a);
            }
            sb.append(a);
        }
        return sb.toString();
    }



    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(nums[i],-1);
        }
        int c = 0;
        while(head!=null){
            head = doSpiralMatrix(m,n,head,nums,c);
            c++;
        }
        return nums;
    }

    public static ListNode doSpiralMatrix(int m,int n,ListNode head,int[][] nums,int c){
        for (int i = c; i < n -c &&head!=null; i++) {
            nums[c][i] = head.val;
            head = head.next;
        }

        for (int i = c+1; i < m-1-c&&head!=null; i++) {
            nums[i][n-c-1] = head.val;
            head = head.next;
        }

        for (int i = n-c-1; i > c &&head!=null; i--) {
            nums[m-c-1][i] = head.val;
            head = head.next;
        }

        for (int i = m-c-1; i > c&&head!=null; i--) {
            nums[i][c] = head.val;
            head = head.next;
        }
        return head;
    }



    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if(i-delay>0){
                sum = ((sum+dp[i-delay])%1000000007);
            }
            if(i-forget>0){
                sum = ((sum+1000000007-dp[i-forget])%1000000007);
            }
            dp[i] = sum;
        }
        long ans = 0;
        for (int i = n-forget+1;i<=n;i++){
            ans= (ans+dp[i])%1000000007;
        }
        return (int)(ans%1000000007);
    }


    long ans = 0;
    int mod = 1000000007;
    int[][] f = {{-1,0},{1,0},{0,-1},{0,1}};
    int m;
    int n;

    public static void main(String[] args) {
        int[][] a ={{12469,18741,68716,30594,65029,44019,92944,84784,92781,5655,43120,81333,54113,88220,23446,6129,2904,48677,20506,79604,82841,3938,46511,60870,10825,31759,78612,19776,43160,86915,74498,38366,28228,23687,40729,42613,61154,22726,51028,45603,53586,44657,97573,61067,27187,4619,6135,24668,69634,24564,30255,51939,67573,87012,4106,76312,28737,7704,35798}};
        System.out.println(new No300().countPaths(a));
    }
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        long[][] temp = new long[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!flag[i][j]){
                    dfs(grid,i,j,flag,temp,0);
                }
            }
        }
        return (int)(ans%mod);
    }

    public long dfs(int[][] grid,int x,int y,boolean[][] flag,long[][] temp,int pre){
        if(x<0||x>=m||y<0||y>=n){
            return 0;
        }
        if(grid[x][y]<=pre){
            return 0;
        }
        if(flag[x][y]){
            return temp[x][y];
        }
        flag[x][y] = true;
        long res = 0;
        for(int i=0;i<4;i++){
            long a = dfs(grid,x+f[i][0],y+f[i][1],flag,temp,grid[x][y]);
            res = (res+a)%mod;
        }
        temp[x][y] = (res+1)%mod;
        ans = (ans+temp[x][y])%mod;
        return temp[x][y];


    }
}
