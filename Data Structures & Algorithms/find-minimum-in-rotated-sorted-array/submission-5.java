class Solution {
    /*
    Notes: l <= r, look for a specific target
    l < r, narrow down the range until one element.

    
    */
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int m = l + (r -l)/2; //avoid integer overflow
            if(nums[m] > nums[r]){
                l = m+1;
            }else{
                r = m;
            }
        }
        return nums[l];
    }
}
