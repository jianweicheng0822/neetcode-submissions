class Solution {
    /*
    DFS Or BFS:

   1. Explore to find '1' and connect with others '1'. 
   2. count how many times we have to perform dfs or bfs
   3. return the result

   Edge case:
   Grid is null or empty

    */
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length == 0){
            return 0;
        }
        int r = grid.length;
        int c =grid[0].length;
        int count =0;
        for(int i =0; i < r; i++){
            for(int j=0; j < c; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int r, int c, char[][]grid){
         if(r < 0 || c < 0 || r >= grid.length || c>=grid[0].length || grid[r][c] != '1'){
            return;
         }
         grid[r][c] = 0;
         dfs(r+1, c ,grid);
        dfs(r-1, c ,grid);
           dfs(r, c+1 ,grid);
            dfs(r, c-1 ,grid);
    }
}
