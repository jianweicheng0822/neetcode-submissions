class Solution {
    /*

    Trie + dfs

    1. Build trie in words list
    2. search board
    3. add result

    root  ""
            c
          a
       t 
    */
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }
    private TrieNode root;
    private List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        if (board == null || board.length == 0 || board[0].length == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        int r = board.length;
        int c = board[0].length;
        // Build trie
        for (String word : words) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                if (!cur.children.containsKey(ch)) {
                    cur.children.put(ch, new TrieNode());
                }
                cur = cur.children.get(ch);
            }
            cur.word = word;
        }
        // Search
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dfs(board, root, i, j);
            }
        }
        return res;
    }
    private void dfs(char[][] board, TrieNode node, int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length
            || !node.children.containsKey(board[r][c]) || board[r][c] == '#') { 
            return;
        }
       
        char temp = board[r][c];
        TrieNode next = node.children.get(temp); 
        if(next.word != null){
            res.add(next.word);
            next.word = null;
        }
        board[r][c] = '#';
        dfs(board, next, r + 1, c);
        dfs(board, next, r - 1, c);
        dfs(board, next, r, c-1);
        dfs(board, next, r, c+1);
        board[r][c] = temp;
    }
}
