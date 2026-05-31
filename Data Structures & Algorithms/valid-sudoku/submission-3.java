class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        Each row must contain digits 1 -9
        each column 1- 9 no duplicates
        each 3x3 contain the 1-9
        
        check row column, sub-boxes of the board         
        */
        if(board == null || board.length ==0 || board[0].length ==0){
            return true;
        }
        //Check row first
        for(int r =0; r < board.length; r++){
            Set<Character> row = new HashSet<>();
            Set<Character> col  = new HashSet<>();
            for(int c=0; c < board.length; c++){
                if(board[r][c] != '.'){
                if(row.contains(board[r][c])){
                    return false;
                }
                }
                if(board[c][r] != '.'){
                if(col.contains(board[c][r])){
                    return false;
                }
                }
                row.add(board[r][c]);
                col.add(board[c][r]);
            }
        }
        for(int startRow = 0; startRow < 9 ; startRow +=3){
            for(int startCol = 0; startCol <9; startCol +=3){
                Set<Character> s = new HashSet<>();
                for(int r = startRow; r < startRow+3; r++){
                    for(int c =startCol; c < startCol+3; c++){
                         if(board[r][c] == '.'){
                            continue;
                         }
                         if(s.contains(board[r][c])){
                            return false;
                         }
                         s.add(board[r][c]);
                    }
                }
            }
        }
        return true;

        /*
            c
      r 1 2 3
        4 5 6
        7 8 9

        */
    }
}
