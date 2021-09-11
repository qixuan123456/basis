package day21.leetcode;

public class No695 {
    int sum = 0;
    public static void main(String[] args) {
        No695 x = new No695();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(x.maxAreaOfIsland(grid));
    }


    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j]==1){
                    findOne(grid,i,j);
                    max = Math.max(max,this.sum);
                    this.sum = 0;
                }
            }
        }
        return max;
    }
    public void findOne(int[][] grid,int i,int j){
        if(i<0||j<0||i>=grid.length||j>=grid[i].length||grid[i][j]!=1){
            return ;
        }
        grid[i][j] = 0;
        this.sum++;
        findOne(grid,i+1,j);
        findOne(grid,i-1,j);
        findOne(grid,i,j+1);
        findOne(grid,i,j-1);

    }
}
