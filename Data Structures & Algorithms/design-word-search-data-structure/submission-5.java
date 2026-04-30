/*

add new words and search for existing words

'.' dots can be matched any letter. dfs(.) to be replaced any letter and see if exists a word in our tree
    ""
   d
 a
y
*/
class WordDictionary {
   static class Trie{
     Map<Character, Trie> m = new HashMap<>();
     boolean isWord = false;
   }
    private Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
       Trie cur = root;
       for(char c : word.toCharArray()){
           if(!cur.m.containsKey(c)){
              cur.m.put(c, new Trie());
           }
           cur = cur.m.get(c);
       }
       cur.isWord = true;
    }

    public boolean search(String word) {
       return dfs(root, word , 0);
    }
    private boolean dfs(Trie cur, String word, int index){
        //Terminal condition
        if(index == word.length()){
            return cur.isWord;
        }
        char c = word.charAt(index);
        if(c == '.'){
        for(Trie n : cur.m.values()){
            if(dfs(n, word, index+1)){
                return true;
            }
        }
        }
        if(!cur.m.containsKey(c)){
            return false;
        }
        return dfs(cur.m.get(c), word, index+1);
    }
}
