class Solution {
    public boolean checkInclusion(String s1, String s2) {
       /*
        edge cases: 
            s1 = "" || s1 = null, return true
            s2 = "" || s2 = null, return false
            s1.length() > s2.length(), return false
       Approach:
           s1 = "abc", s2 = "lecaabee"
                                r
                             l
                a = 0                      
                 
       */
       if( s1 == null || s1.isEmpty()){
        return true;
       }
       if(s2 == null || s2.isEmpty()){
        return false;
       }
       if(s1.length() > s2.length()){
        return false;
       }
       Map<Character, Integer> need = new HashMap<>();
       for(char c: s1.toCharArray()){
           need.put(c, need.getOrDefault(c,0) +1);
       }
       int left =0;
       int valid =0;
       Map<Character, Integer> window = new HashMap<>();
       for(int right =0; right < s2.length(); right++){
             char temp = s2.charAt(right);

             if(need.containsKey(temp)){
                window.put(temp, window.getOrDefault(temp,0) +1);
                if(need.get(temp).intValue() == window.get(temp).intValue()){
                    valid++;
                }
             }
             //shrink the window
             if(right - left +1 > s1.length()){
                  char leftChar = s2.charAt(left);
                  if(need.containsKey(leftChar)){
                       if(need.get(leftChar).intValue() == window.get(leftChar).intValue()){
                             valid--;
                          }
                          window.put(leftChar, window.get(leftChar) -1);
                  }
                  
                  left++;
             }
             if(right - left + 1 == s1.length() && valid ==  need.size()){
                return true;
             }
       }
       return false;
    }
}
