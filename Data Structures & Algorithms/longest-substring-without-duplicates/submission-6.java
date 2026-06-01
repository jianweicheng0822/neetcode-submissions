class Solution {
    /*
    Longest substring without repeating characters.

    Sliding window approach:
    s = "abcbc"
         l
            r
    */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int l =0;
        int r =0;
        int length = 0;
        while(r < s.length()){
            char c = s.charAt(r);
            while(set.contains(c)){
              set.remove(s.charAt(l));
              l++;
            }
            set.add(c);
             length = Math.max(length, r -l +1);
            r++;
           // s.add(c);
        }
        return length;

    }
}
