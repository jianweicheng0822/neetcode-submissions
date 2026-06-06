class Solution {
    /*
    Input: s = "OUZODYXAZV", t = "XYZ"
    
    Edge case:
     1. s.length() < t.length()
     2. s is null or empty 
     3. t is null or empty
     
    Approach:
    Sliding Window + HashMaps + Valid (int variable to count)

    Using two hashmaps to count the freqs of both s and t strings.

    Sliding window:
    left pointer -  shrink the window to see if possible reduce the length, and find the best result. 
    right pointer - expand the window to find possible result

    if valid == t's hashmap.size(), shrink the window 


    Output: "YXAZ"
    */
    public String minWindow(String s, String t) {
        Map<Character, Integer> th = new HashMap<>();
        Map<Character, Integer> sh = new HashMap<>();
        for(char c : t.toCharArray()){
            th.put(c, th.getOrDefault(c,0) +1);
        }
        int valid = 0;
        int require = th.size();
        int bestLength = Integer.MAX_VALUE;
        int left =0;
        int right =0;
        int[] res = new int[2];
        while(right < s.length()){
            char r = s.charAt(right);
            sh.put(r, sh.getOrDefault(r,0)+1);
            if(th.containsKey(r) && th.get(r).equals(sh.get(r))){
                valid++;
            }
            //Shrink window
            while(valid == require){
               if(right - left  + 1  < bestLength){
                  bestLength = right - left +1;
                  res[0] = left;
                  res[1] = right+1; 
               }
               char l = s.charAt(left);
               sh.put(l, sh.getOrDefault(l,0) -1);
               if(th.containsKey(l) && sh.get(l) < th.get(l)){
                valid--;
               }
               left++;
            }
            right++;
        }
        if(bestLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(res[0], res[1]);
    }
}
