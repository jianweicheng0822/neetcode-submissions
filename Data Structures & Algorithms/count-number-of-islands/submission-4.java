class Solution {
    /*
    input : 2d character grid  ->  char[][]grid

    Descirption:
    '1' -> land
    '0' -> water

    islands is formed by connecting adjacnet lands (4 directions ) and is surrounded by water

    Output: int -> integer type -> return the number of islands

    Approach:

    count -> count how many islands

    Perform dfs or bfs algorithm to start with land '1', explore 4 directions to make all possible
  land to be '0'.

    return count

    Example:
    Input: grid = [
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
  ]

    Edge case:
    1. grid is null or empty -> return 0
    2. (speical case )grid is filled with all 0. reutnr 0

    Time complexity;

    Space complexity:


    */

    public int numIslands(char[][] grid) {
        // Avoid null pointer exception or empty board
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][]grid, int r, int c){
        //Boundary case
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != '1'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}
