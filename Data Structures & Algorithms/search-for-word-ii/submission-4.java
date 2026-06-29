class Solution {
    /*
    
    Input: char[][]board, String[] words
    
    Output: find possible words 

   Brute force:
   
   use dfs to serach every possible one
    
    
    */
    
    public List<String> findWords(char[][] board, String[] words) {
          if(board == null || board.length ==0 || board[0].length ==0){
               return new ArrayList<>();
          }
          List<String> res = new ArrayList<>();
          for(String word : words){
             if(exist(board, word)){
                 res.add(word);
             }
          }
          return res;
    }
    private boolean exist(char[][]board, String word){
        int r = board.length;
        int c = board[0].length;
        for(int i=0; i < r; i++){
            for(int j=0; j < c; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][]board, int r, int c, String word, int index){
          //Terminal condition
          if(index == word.length()){
            return true;
          }
          if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)){
             return false;
          }
          char temp = board[r][c];
          board[r][c] = '#';
          boolean found = dfs(board,r+1,c,word,index+1) || dfs(board,r,c+1,word,index+1) || dfs(board,r-1,c,word,index+1) || dfs(board,r,c-1,word,index+1);
          board[r][c] = temp;
          return found;
    }
}
