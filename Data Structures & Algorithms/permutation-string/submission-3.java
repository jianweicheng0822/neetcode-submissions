class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //Edge case
        if(s1.length() > s2.length()){
            return false;
        }
        Map<Character, Integer> targetFreq = new HashMap<>();
        Map<Character, Integer> windowFreq = new HashMap<>();
        for(char c : s1.toCharArray()){
            targetFreq.put(c, targetFreq.getOrDefault(c,0) +1);
        }
        int l =0;
        int r =0;
        //Expand the window
        while(r < s2.length()){
            char c = s2.charAt(r);
            windowFreq.put(c, windowFreq.getOrDefault(c,0) +1);
            //Shrink the window when it has possible result
            if(r - l + 1 > s1.length()){
                char left = s2.charAt(l);
                windowFreq.put(left, windowFreq.get(left) -1);
                if(windowFreq.get(left) == 0){
                    windowFreq.remove(left);
                }
                l++;
            }
            if(r-l +1 == s1.length() && windowFreq.equals(targetFreq)){
                return true;
            }

            r++;
        }
        return false;
    }
}
