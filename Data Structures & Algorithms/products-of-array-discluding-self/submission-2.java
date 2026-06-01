class Solution {
    /*
    prefix = [1 1 2 8]
    suffix.  [48  24  6  1]
    
    */
    public int[] productExceptSelf(int[] nums) {
       int[]prefix = new int[nums.length];
       int[]suffix = new int[nums.length];
       //Calculate prefix first
       prefix[0] = 1;
       int sum = 1;
       for(int i =1; i < nums.length; i++){
        sum *= nums[i-1];
        prefix[i] = sum;
       }  
       suffix[nums.length-1] = 1;
       int product = 1;
       for(int i =nums.length-2; i >= 0; i--){
          product *= nums[i+1];
          suffix[i] = product;
        
       }
       int[]result = new int[nums.length];
       for(int i =0; i < nums.length;i++){
        result[i] = prefix[i] * suffix[i];
       }
       return result;
    }
}  
