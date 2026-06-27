/*
Prefix Tree:
insert(apple);
insert(appe)
       ""
       a
      p
     p
    l e
   e

*/

class PrefixTree {
    static class Trie {
        Map<Character, Trie> m = new HashMap<>();
        boolean isWord = false;
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
        cur.isWord = true;
    }

    public boolean search(String word) {
        Trie cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.m.containsKey(c)) {
                return false;
            }
            cur = cur.m.get(c);
        }
        return cur.isWord;
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
