class Solution {
    /*
    
    Check row and check column and check 3x3 sub boxes
    
    
    */
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length ==0 || board[0].length == 0){
            return false;
        }

        for(int r=0; r < 9; r++){
            Set<Character> checkCol = new HashSet<>();
            Set<Character> checkRow = new HashSet<>();
            for(int c=0; c < 9; c++){
                if(board[r][c] != '.' && checkCol.contains(board[r][c])){
                    return false;
                }
                 if(board[c][r] != '.' && checkRow.contains(board[c][r])){
                    return false;
                }
                checkCol.add(board[r][c]);
                checkRow.add(board[c][r]);
            }
        }
        for(int r =0; r < 9; r +=3){
           for(int c =0;  c < 9; c +=3){
               Set<Character> visited = new HashSet<>();
               for(int ra = r; ra < r+3; ra++){
                for(int ca = c; ca < c+3; ca++){
                    if(board[ra][ca] != '.' &&visited.contains(board[ra][ca])){
                         return false;
                    }
                    visited.add(board[ra][ca]);
                }
               }    
           } 
        }
        return true;
        /*
            c
     r  x x x x x x 
        x x x x x x
        x x x x x x
        x x x x x x
        x x x x x x
        
        */
    }
}
