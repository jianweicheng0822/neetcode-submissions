class Solution {
    /*
    intput: int[][] heights

    Problem Description:

    Pacific Ocean - top and left sides

    Atlantic Ocean - bottom and right sides

    Water can flow in four directions from a cell to neighbor cell with height equal or lower

    output:
    Find all the cells where water can flow from that cell to both the pacific and Atlantic oceans
with 2d list were each element as a list [r,c]

    Approach:
    Input: heights = [
  [4,2,7,3,4],
  [7,4,6,4,7],
  [6,3,5,3,6]
]

  r = 0,  c = 0 means Pacific
  r  = heights.length -1, c  = heights[0].length - 1 means Atlantic

  boolean pacific = fasle;
  boolean atlantic = false;
  Perfrom dfs algorith for each cell to check if it can explore 4 directions to see if it can
possible to hit the both pacific and atlantic. and water flow from a cell to height equal or lower
  prev - 7
  2 3 6 not go back to prev
    */
    private List<List<Integer>> res;
    private boolean isPacific;
    private boolean isAtlantic;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        int r = heights.length;
        int c = heights[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                isAtlantic = false;
                isPacific = false;
                boolean[][] visited = new boolean[r][c];
                dfs(heights, i, j, visited, Integer.MAX_VALUE);
                if(isPacific && isAtlantic){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prev) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length || visited[r][c]
            || heights[r][c] > prev) {
            return;
        }
        if (r == 0 || c == 0) {
            isPacific = true;
        }
        if (r == heights.length - 1 || c == heights[0].length - 1) {
            isAtlantic = true;
        }
        visited[r][c] = true;
        dfs(heights, r + 1, c, visited, heights[r][c]);
        dfs(heights, r - 1, c, visited, heights[r][c]);
        dfs(heights, r, c + 1, visited, heights[r][c]);
        dfs(heights, r, c - 1, visited, heights[r][c]);
    }
}
