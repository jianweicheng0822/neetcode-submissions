class Solution {
    /*
    DFS or BFS

    serach for 1 to connect with others 1, and store the result


    */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    result  = Math.max(dfs(i, j, grid), result);
                }
            }
        }
        return result;
    }
     private int dfs(int r, int c, int[][]grid){
         if(r < 0 || c < 0 || r >= grid.length || c>=grid[0].length || grid[r][c] != 1){
            return 0;
         }
         grid[r][c] = 0;
        return 1 +  dfs(r+1, c ,grid)  + dfs(r-1, c ,grid)  + dfs(r, c+1 ,grid) + dfs(r, c-1 ,grid);
    }
}
