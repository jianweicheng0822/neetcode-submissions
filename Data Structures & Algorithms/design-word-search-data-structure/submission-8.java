class WordDictionary {
/*
addWord
 
      d  b
   a       a 
y            y

'.' every path at that level we have find.
'.' can replaced to any word that lowercase 
*/
static class Trie{
    Map<Character, Trie> m = new HashMap<>();
    boolean isEnd = false;
}
private Trie root;
private boolean find = false;
    public WordDictionary() {
       root = new Trie();
    }

    public void addWord(String word) {
        Trie cur = root;
        for(char c: word.toCharArray()){
            if(!cur.m.containsKey(c)){
                cur.m.put(c, new Trie());
            }
            cur = cur.m.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = root;
        find = false;
        backtrack(cur, word, 0);
        return find;
    }
    private void backtrack(Trie cur, String word, int index){
        //Terminal condition
        //sad
        //serach sa
        if(index == word.length()){
            if(cur.isEnd == true){
                 find = true;
            }
            return;
        }
        char c = word.charAt(index);
        if(c == '.'){
          for(char temp = 'a'; temp <= 'z'; temp++){
              if(cur.m.containsKey(temp)){
                 backtrack(cur.m.get(temp), word, index+1);
              }
          }
        }else{
            if(!cur.m.containsKey(c)){
               return;
            }else{
                backtrack(cur.m.get(c), word, index+1);
            }
        }
        
    }
}
