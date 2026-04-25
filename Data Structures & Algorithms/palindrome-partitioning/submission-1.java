class Solution {
    /*
    Input : String s 

    Output: all possible lists of palindromic substrings
    
    Edge case:
    s = null or empty, return a empty list
    
    Example:
    s = "aab"
     
    Aprroach:
       aab? no
       a,ab no
       aa,b yes
       a,a,b yes

    aab
 a,ab   aa,b     
 a,a,b
 
 Backtracking algorithm to collect the path when it reachs to the leaf node as result.

 startIndex to control the direction.


    
    */
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        //Edge case
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        backtrack(s, new ArrayList<>(), 0);
        return res;
    }
    private void backtrack(String s, List<String> path, int startIndex){
      //Terminal condition - collect result
      if(startIndex == s.length()){
         res.add(new ArrayList<>(path));
         return;
      }
      for(int i = startIndex; i < s.length(); i++){
        String temp = s.substring(startIndex, i+1);
        //check if this string is palindrome
        if(isPalindrome(temp)){
           path.add(temp);
           backtrack(s,path,i+1);
           path.remove(path.size()-1);
        }
      }
    }
    private boolean isPalindrome(String s){
        int l =0;
        int r =s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
