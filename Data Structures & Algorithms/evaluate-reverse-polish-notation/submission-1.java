class Solution {
    /*

    Use a stack to solve this problem.

    Edge case:
    1. tokens is null or empty -> nullpointer exception
    2. when operands meets, and has st.size() < 2
    3. not valid arithmetic expression 

    */
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<String> st = new Stack<>();
        for(String s : tokens){
            if(s.equals("*") || s.equals("-") || s.equals("+") || s.equals("/")){
               if(st.size() >= 2){
                  if(s.equals("+")){
                    int a = Integer.parseInt(st.pop());
                    int b = Integer.parseInt(st.pop());
                    st.push(Integer.toString(a+b));
                  }else if(s.equals("-")){
                    int a = Integer.parseInt(st.pop());
                    int b = Integer.parseInt(st.pop());
                    st.push(Integer.toString(b-a));
                  }else if(s.equals("*")){
                    int a = Integer.parseInt(st.pop());
                    int b = Integer.parseInt(st.pop());
                    st.push(Integer.toString(a * b));
                  }else if(s.equals("/")){
                    int a = Integer.parseInt(st.pop());
                    int b = Integer.parseInt(st.pop());
                  st.push(Integer.toString(b / a ));
                  }
               }
            }else{
                st.push(s);
            }
            
        }
        if(st.size() ==0){
            return 0;
        }
        int result = Integer.parseInt(st.pop());
        return result;
    }
}
