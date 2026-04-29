/*
Time complexity: O(n) for each method
Space complexity:O(m * n)

n stands for the length of a word
m stands for the number of words.

   apple  appd

   ""
    a
   p
  p
 l d
app return true 
 e end true



*/
class PrefixTree {
    class Trie {
        Map<Character, Trie> m = new HashMap<>();
        boolean isEnd = false;
    }
    private Trie root;
    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.m.containsKey(c)) {
                cur.m.put(c, new Trie());
            }
            cur = cur.m.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.m.containsKey(c)) {
                return false;
            }
            cur = cur.m.get(c);
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = root;
        for (char c : prefix.toCharArray()) {
            if (!cur.m.containsKey(c)) {
                return false;
            }
            cur = cur.m.get(c);
        }
        return true;
    }
}
