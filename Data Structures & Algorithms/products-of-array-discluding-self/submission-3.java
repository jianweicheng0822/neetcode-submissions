class Solution {
    /*
    Input : 1 2 4 6

    48 24 12 8 

48 : 2 x 4 x 6
24 : 1 x 4 x 6
12 : 1 x 2 x 6
8 : 1 x 2 x 4


48 24 6 1

        1  * 6 = 6
        6  x 4
1  1  2 8

1  1  
prefix[i]  = 1 * prefix[i-1]
      
    prefix 
    suffix
    */
    public int[] productExceptSelf(int[] nums) {
          if(nums == null || nums.length ==0){
            return new int []{};
          }     
          int n = nums.length;
          int[]prefix = new int[n];
          int[]suffix = new int[n];
          prefix[0] = 1;
          suffix[n-1] = 1;
          for(int i =nums.length -2; i >= 0; i--){
              suffix[i] = nums[i+1] * suffix[i+1];
          }
          for(int i =1; i < nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
          }
          int[]ans = new int[n];
          for(int i =0; i < nums.length; i++){
                ans[i] = prefix[i] * suffix[i];
          }
          return ans;
    }
}  
