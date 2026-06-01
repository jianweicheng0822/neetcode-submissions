class Solution {
    /*
    Longest Repeating Character Replacement

     s = "XXYY", k = 1
              r-l+ 1 - freq = 2 > k
        X : 2
        Y : 2
        maxFreq = 2
        Condition      
    */
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0|| k < 0){
            return 0;
        }
        int result = 0;
        Map<Character,Integer> m = new HashMap<>();
        int l = 0;
        int maxFreq =0;
        //Expand the window
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            m.put(c, m.getOrDefault(c,0) +1);
            maxFreq = Math.max(m.get(c), maxFreq);
            if(i - l + 1 - maxFreq > k){
                m.put(s.charAt(l), m.get(s.charAt(l))-1);
                l++;
            }
            result = Math.max(i-l+1, result);
            
        }
        return result;
    }
}
