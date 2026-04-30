class Solution {
    /*

    input :  int[][] grid - > 2d grid  m x n  with three possible values

    Rule:
    -1 -> a water cell can't be traversed
    0 - > a treasure chest
    INF - a lnd call that can be traversed.  2^31 -1  to be INF

    fill INF with distance to its nearest 0. if INF can not 0, remain INF

    grid can be 4 directions

    output:
    void type method - modify the grid in place to make INF to 0 with nearest distance

    Approach:
    Muplitple Sources BFS algorithm:

    Queueu to offer all treasure chest positions into our queue, explore all 4 directions to find
   the INF.


   Edge case:
   grid is null or empty
    */
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while (!q.isEmpty()) {
            int size = q.size(); // distance =0;
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int row = cur[0];
                int column = cur[1];
                for (int j = 0; j < 4; j++) {
                    int next_row =  row + dir[j][0];
                    int next_col = column + dir[j][1];
                    if( next_row < 0 || next_row >= grid.length || next_col < 0 || next_col >= grid[0].length ||grid[next_row][next_col] != Integer.MAX_VALUE){
                            continue;
                    }
                    grid[next_row][next_col] = grid[row][column] + 1;
                    q.offer(new int[]{next_row, next_col});
                }
            }
        }
    }
}
