package test;

public class honghua {
    public static void main(String[] args) {
        char[][] nums ={{'M','M','F','M','M'},
                {'M','M','M','M','M'},
                {'M','M','F','F','M'},
                {'M','M','F','M','M'},
                {'M','M','F','M','F'}};
        int m = 5;
        int n = 5;
        int res = 0;
        res = numIslands(nums);
        System.out.println(res);

    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == 'F') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }
    public static void  dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 'M') {
            return;
        }
        grid[r][c] = 'M';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
