class Solution {
    /*
    1. s or n  == null
    2. length of s != length of n
    */
    public boolean isAnagram(String s, String t) {
         if(s == null || t == null || s.length() != t.length()){
            return false;
         }
         Map<Character, Integer> m = new HashMap<>();
         for(char c : s.toCharArray()){
              m.put(c, m.getOrDefault(c,0) + 1);
         }
         for(char c: t.toCharArray()){
            if(!m.containsKey(c)){
               return false;
            }
            m.put(c, m.get(c)-1);
            if(m.get(c) == -1){
                return false;
            }
         }
         return true;
    }
}
