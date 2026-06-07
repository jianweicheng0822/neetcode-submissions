class Solution {
    /*
    
    intput: heights -> each height of a bar

    return the area of largest rectangle 


    heights = [7,1,7,2,2,4]

  area = height * width

  Use a stack to store the indicates.
  s = [1]. 7 < 2,
  pop().  2,  left: 2 - i = 0,  right : 3- 2 =1
  right + 
   
    heights = [2 1 2 0]
    1
    
    */
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        Stack<Integer> s = new Stack<>();
        int maxarea  =0;
        for(int i =0; i <= heights.length; i++){
            
            int currentHeight = 0;
            if(i == heights.length){
                currentHeight = 0;
            }else{
                currentHeight = heights[i];
            }
            while(!s.isEmpty()&& heights[s.peek()] > currentHeight){
                int current = s.pop();
                int right = i - current;
                int left = current;
                if(!s.isEmpty()){
                    left =  current - s.peek() - 1;
                }
                int width = left + right;
                maxarea = Math.max(heights[current] * width , maxarea);
            }
            s.push(i);
        }
        return maxarea;
    }
}
