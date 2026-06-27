class Solution {
    /*
    Backtracking:

    Find every path that contains if match with word



    */
    private boolean res = false;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int r = board.length;
        int c = board[0].length;
        int index = 0;

        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                backtrack(i, j, index, board, word);
            }
        }
        return res;
    }
    private void backtrack(int r, int c, int index, char[][] board, String word) {
        if (index == word.length()) {
            res = true;
            return;
        }
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
            || word.charAt(index) != board[r][c]) {
            return;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        backtrack(r + 1, c, index + 1, board, word);
        backtrack(r - 1, c, index + 1, board, word);
        backtrack(r, c - 1, index + 1, board, word);
        backtrack(r, c + 1, index + 1, board, word);
        board[r][c] = temp;
    }
}
