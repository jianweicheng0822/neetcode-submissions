class Solution {
    /*

    input:
     -  2d grid characters board -> char[][]board
     - a list of string words - >  List<String> words or String[] words

     To-Do:

     form a word with a path in the board with 4 directions. the same cell may not be used more than
    once

    Output:
     return all words that are valid in the wordlist


     Function:
     public List<String> formWords(char[][]board, String[] words){

     }

     Example:


    Appraoch:
    search a word from the wordlist in the board.

    Brute force:
    Perform dfs algorithm to start with any character in the board,
    and explore the neighbors(4 directions) to see if exists in our board.
    check each word in our board.
    O( how many of words in our list  * row  *  column *  4^L) is not very effienct

    Prefix tree or trie tree
    precompute our words from our wordlist into a tree data strcture
    O( row * column * 4^L)


    */
    class Trie {
        Map<Character, Trie> m = new HashMap<>();
        String word = "";
    }
    private Trie root = new Trie();
    private List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0 || words == null
            || words.length == 0) {
            return new ArrayList<>();
        }
        buildTrie(words);
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dfs(board, i, j, visited, root);
            }
        }
        return res;
    }
    private void dfs(char[][] board, int r, int c, boolean[][] visited, Trie node) {
        // Boundary case
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]) {
            return;
        }
        char ch = board[r][c];
        Trie next = node.m.get(ch);
        if(!node.m.containsKey(ch)){
            return;
        }
        // Terminal condition
        if (!next.word.equals("")) {
            res.add(next.word);
            next.word = ""; 
        }
        visited[r][c] = true;
        dfs(board, r + 1, c, visited, next);
        dfs(board, r - 1, c, visited, next);
        dfs(board, r, c+1, visited, next);
        dfs(board, r, c-1, visited, next);
        visited[r][c] = false;
    }
    private void buildTrie(String[] words) {
        for (String s : words) {
            Trie cur = root; // reset by word
            for (char c : s.toCharArray()) {
                if (!cur.m.containsKey(c)) {
                    cur.m.put(c, new Trie());
                }
                cur = cur.m.get(c);
            }
            cur.word = s;
        }
    }
}
