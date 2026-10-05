class Solution {
    /*
    Check if String is palindrome


    
    
    */
    public boolean isPalindrome(String s) {
        if( s == null){
            return false; // it depends on the interviewer
        }
        if( s.length() ==0){
            return true;
        }
        int l = 0;
        int r =s.length()-1;
        while(l < r){
           
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
          while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}
