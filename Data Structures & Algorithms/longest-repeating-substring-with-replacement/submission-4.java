class Solution {
    public int characterReplacement(String s, int k) {
        /*
        Sliding window approach:
        window size =  right - left + 1
        left -  shrink the window, and search the next possible window/solution
        right - expand the window until window size minus maxFreq exceeds k
       
       Edge case:
           1. s is null or empty (Null pointer excepetion)
           2. k <= 0  (none characters can be replacement) 
           3. k >= s.length()   (all characters can be replacement)
       Space: O(n) and n stands for s.length()  -> we use the hashmap to count the freq.
       Time: O(N) and n  stands for s.length()
           
        s = "XYYXY"  k=2 
             y:3   windowsize  - maxFreq > k // shrink
             x:2 
     Creating windows for these possible results
        */
        Map<Character, Integer> m = new HashMap<>();
        int maxFreq = 0;
        int left =0;
        int right =0;
        int result =0;
        while(right < s.length()){
            char c = s.charAt(right);
            m.put(c, m.getOrDefault(c, 0) +1);
            maxFreq = Math.max(maxFreq, m.get(c));
            if(right - left + 1 - maxFreq > k){
                char a = s.charAt(left);
                m.put(a, m.get(a) -1);
                left++;

            }
            result = Math.max(result, right -  left + 1);
            right++;
        }
        return result;
    }
}
