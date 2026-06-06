class Solution {
    /*
   Input: nums = [1,2,1,0,4,2,6], k = 3
   Output: List of max elements at each step.
   
   int[] res = new int[nums.length - k +1]

   [1 2 1] 0 4 2 6 max : 2
   1 [2 1 0] 4 2 6 max 2
   Edge case:
   nums is null or empty, k <= 0 

   Brute force:
   loop through the nums, 
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]res = new int[nums.length - k +1];
        
        for(int i =0; i < nums.length -k + 1; i++){
            int max = Integer.MIN_VALUE;
            for(int j =i; j < i+k; j++){
                max = Math.max(nums[j], max);
            }
            res[i] = max;
        }
        return res;
    }
}
