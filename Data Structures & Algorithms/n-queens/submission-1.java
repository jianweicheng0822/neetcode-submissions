class Solution {
    /*
    backtrack:



 1. Build the board with empty '.'
 2. try every possible place to put the queen and apply the rules and see if it is valid board.




    */
    private List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] board = new char[n][n];
        // Build the board with empty '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0, board);
        return res;
    }
    private void dfs(int r, char[][] board) {
        if (r == board.length) {
            res.add(build(board));
            return;
        }
        for (int c = 0; c < board.length; c++) {
            if (isValid(r, c, board)) {
                board[r][c] = 'Q';
                dfs(r + 1, board);
                board[r][c] = '.';
            }
        }
    }
    private List<String> build(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
    private boolean isValid(int r, int c, char[][] board) {
        // horizontally(done), vertically(done), and diagonally

        // Bound case
        if (r < 0 || r >= board.length || c < 0 || c >= board.length) {
            return false;
        }
        //check column
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') {
                return false;
            }
        }
        //Check diagonally direction
        
        for(int i = r-1, j = c-1; i >=0 && j >=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = r-1, j = c+1; i >=0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
        /*     
     r=0      Q
           
     r=2 Q         

        
        */
    }
}
