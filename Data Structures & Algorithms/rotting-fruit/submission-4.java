class Solution {
    /*
    input : int[][] grid - 2d matrix gird
    Description:
    
    0 is empty cell
    1 is fresh fruit
    2 is rotten fruit
    
    every minute, a fresh fruit is nearby 4 directions the rotten fruit, turn the 1 to be 2

    return the minimum minutes  0 fresh fruit left or return -1
    */
    public int orangesRotting(int[][] grid) {
         int r = grid.length;
         int c = grid[0].length;
         int totalFresh = 0;
         Queue<int[]> q = new LinkedList<>();
         int min = 0;
         for(int i =0; i < r; i++){
            for(int j =0; j < c; j++){
                if(grid[i][j] == 1){
                    totalFresh++;
                }else if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
         }
         int[][] dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};
         while(!q.isEmpty()){
            int size = q.size();
            boolean rotated = false;
            for(int i =0; i< size; i++){
                int[] cur = q.poll();
                for(int j =0; j < 4; j++){
                    int next_r = cur[0] + dir[j][0];
                    int next_c = cur[1] + dir[j][1];
                    if(next_r < 0 || next_r >= grid.length || next_c < 0 || next_c >= grid[0].length || grid[next_r][next_c] != 1){
                        continue;
                    }
                    grid[next_r][next_c] = 2;
                    totalFresh--;
                    rotated = true;
                    q.offer(new int[]{next_r, next_c});
                }   
            }
            if(rotated){
                min++;
            }
         }
         if(totalFresh > 0){
            return -1;
         }
         return min;
    }
}
