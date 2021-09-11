package day21.leetcode;

public class No62 {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,3));
    }
    public static int uniquePaths(int m, int n) {
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    a[i][j] = 1;
                }
                else {
                    a[i][j] = a[i-1][j] + a[i][j-1];
                }
            }
        }
        return a[m-1][n-1];
    }
}
