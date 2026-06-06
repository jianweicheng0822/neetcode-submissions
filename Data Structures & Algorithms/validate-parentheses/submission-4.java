class Solution {
    /*
Input: s = "([{}])"


(  
    */
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int balance = 0;
        for(char c : s.toCharArray()){
            ;
            if(c == '(' || c == '{' || c =='['){
                st.push(c);
                balance++;
            }else if (c == ']' || c == ')' || c == '}'){
                if(st.size() ==0){
                   return false;
                }
                char close = st.pop();
                if(close == '(' && c == ')'){
                    balance--;
                }else if(close == '[' && c == ']'){
                    balance--;
                }else if(close == '{' && c == '}'){
                    balance--;
                }
            }

        }
        if(balance == 0){
            return true;
        }
        return false;
    }
}
