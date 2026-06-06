class MinStack {
     /*            0
     push 1        1
     push 2        1        
     push 0.    if stack is not empty, it compares with stack
     getMin            
     pop
     top. 
     min 
Using two stacks


     */
    private Stack<Integer> min;
    private Stack<Integer> s;
    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else{
            min.push(Math.min(min.peek(), val));
        }
    }
    
    public void pop() {
        min.pop();
        s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
