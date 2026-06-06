class Solution {
    /*
    Slidng window approach:

    fixed window size  - s1.length()
         s1 = "abc"
         s2 = "lecabee"

     
    left pointer -  shrink the window and adjust the content inside the string
    right pointer - expand the window to find possible match with s2.

    For Example:
             s1 = "abc"
             s2 = "lecabee"

     l = 0
     r = 2

     we first look "lec", that doesn't match "abc". we shrink the window, and remove the 'l' in our hashmap. then expand the window to add 'a'. Repeating the process and see if we can find one.
     
    
    */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> require = new HashMap<>();
        int l =0;
        int r = 0;
        for(char c: s1.toCharArray()){
            need.put(c,need.getOrDefault(c,0) +1);
        }
        while(r < s2.length()){
            char right = s2.charAt(r);
            require.put(right, require.getOrDefault(right,0) +1);
            if(r - l + 1 > s1.length()){
                char left = s2.charAt(l);
                require.put(left, require.get(left) -1);
                if(require.get(left) ==0){
                    require.remove(left);
                }
                l++;
            }
             if(r - l + 1 == s1.length() && need.equals(require)){
                return true;
            }
            r++;
        }
        return false;
    }
}
