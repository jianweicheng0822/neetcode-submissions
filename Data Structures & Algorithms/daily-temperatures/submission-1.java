class Solution {
    /*
    Input: int[] temperatures -> daily temperature

    Output: int[] result -> 0 or ith day when warmer temperature appear

    Example:
    Input: temperatures = [30,29, 38,30,36,35,40,28]

    Output: [1,4,1,2,1,0,0]

    stack: [0 1]

    temperatures[s.peek()]
    
    */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[]result = new int[temperatures.length];
      for(int i =0; i < temperatures.length; i++){
     
            while(!s.isEmpty() && temperatures[s.peek()] < temperatures[i]){
                 int index = s.pop();
                 result[index] = i - index;
            }
        
            s.push(i);
        }
       
        return result;
    }
}
