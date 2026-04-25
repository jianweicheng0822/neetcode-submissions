class Solution {
    /*
    Edge case Special case:
    1. empty word
    2. empty board or null, has word 

    Approach : loop through this maze, and perform dfs algorithm to find a word if exists in the maze.

    DFS algorithm:
    
    word.charAt(index) == board[r]][c] dfs to check 
 

    'cat'
    
    */
    public boolean exist(char[][] board, String word) {
        //Empty board or null
        if(board == null || board.length == 0 || board[0].length ==0){
            return false;
        }
        //Has board, but empty word
        if(word == null || word.length() == 0){
            return true;
        }
        int r = board.length;
        int c = board[0].length;
        int index = 0;
        boolean[][]visited = new boolean[r][c];
        for(int i =0; i < r; i++){
            for(int j =0; j < c; j++){
                if(board[i][j] == word.charAt(index)){
                    if(dfs(board,i,j,word,visited,index)){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }
    private boolean dfs(char[][]board, int r, int c, String word, boolean[][]visited, int index){
              //Common case
              if(index == word.length()){
                return true;
              }
              if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || visited[r][c] || word.charAt(index) != board[r][c]){
                return false;
              }
            
             visited[r][c] = true;
             boolean found = dfs(board, r+1, c, word,visited, index+1) || dfs(board, r-1, c, word,visited, index+1) || dfs(board, r, c+1, word,visited, index+1) || dfs(board, r, c-1, word,visited, index+1);
             visited[r][c] = false;
             return found;
    }
}
