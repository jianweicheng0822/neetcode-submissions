class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    count = Math.max(count,dfs(grid, i, j));
                }
            }
        }
        return count;
    }
     private int dfs(int[][]grid, int r, int c){
        //Boundary case
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;
        return 1 + dfs(grid, r+1, c) +  dfs(grid, r-1, c) + dfs(grid, r, c+1) + dfs(grid, r, c-1);
    }
}
