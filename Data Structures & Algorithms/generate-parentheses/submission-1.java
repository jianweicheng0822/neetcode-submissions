class Solution {
    /*
    n = 3

    1.((()))
    2.(()())

    open < n
     backtrack
    close < open 
     backtrack
    
    */
    private  List<String> res;
    public List<String> generateParenthesis(int n) {
        if(n <=0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
       backtrack(n, new StringBuilder(), 0, 0);
       return res;
    }
    private void backtrack(int n, StringBuilder sb, int open, int close){
        if(n * 2 == sb.length()){
            res.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append("(");
            backtrack(n, sb, open+1, close);
            sb.setLength(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            backtrack(n, sb, open, close+1);
            sb.setLength(sb.length()-1);
        }
    }
}
