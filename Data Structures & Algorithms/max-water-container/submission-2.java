class Solution {
    /*
    maxArea between two bars



    Two pointer:
    height = [1,7,2,5,4,7,3,6]
              l.            r
    width = r-l
    height = Math.max(height[l], height[r]);
    area = height * width

    how to move pointers
    Every time if we move either left pointer or right pointer, it will short the width.
    So we have to find a higer height.
    we know 1 is less than 6. so we move whose less height first.
    if(height[l] < height[r]){
      l++;
     }else{
     r--;
     
     }
    */
    public int maxArea(int[] heights) {
        //Edge case
        if(heights == null || heights.length ==0){
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int l =0; // left pointer
        int r =heights.length-1; // right pointer
        while(l < r){
            //Caculate
            int height = Math.min(heights[l], heights[r]);
            int width = r-l;
            int area = height * width;
            result = Math.max(area,result);
            //Move Pointers
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
}
