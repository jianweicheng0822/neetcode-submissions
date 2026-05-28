class Solution {
   /*
   input: s -> string, t-> string 
   

   output: true if two strings are anagrams of each other 
   
   Approach:
   sort both strings, and compare them from scanning left to right if matches every character
   */
    public boolean isAnagram(String s, String t) {
        //Edge case
        if(s.length() != t.length()){
            return false;
        }
         Map<Character,Integer> m = new HashMap<>();
         for(char c: s.toCharArray()){
            m.put(c, m.getOrDefault(c,0) +1);
         }
         for(char c : t.toCharArray()){
            if(!m.containsKey(c)){
                return false;
            }
            m.put(c, m.get(c)-1);
            if(m.get(c) < 0){
                return false;
            }
         }
         return true;
    }
}
