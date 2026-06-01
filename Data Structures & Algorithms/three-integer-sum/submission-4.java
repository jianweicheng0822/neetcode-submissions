class Solution {
    /*
    nums = [-1,0,1,2,-1,-4]
    nums = [-4，-1，-1，0，1，2]
    1. Brute force (3 loops + HashSet)
    2. HashMap + HashSet ( O (n^2))
    3. two pointer  (save some space)


    Approach:
      nums = [-4，-1，-1，0，1，2]
                      l.    r. k
               when left + r + k < 0, move r 
               when l + r + k > 0 , move k
               l > 0 && nums[l-1] = nums[l] continue
    1. sort the nums 
    
    */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(l < nums.length-2){
           if(l > 0 && nums[l-1] == nums[l]){
            l++;
            continue;
           }
           if(nums[l] > 0){
            break;
           }
           int r = l+1;
           int k = nums.length-1;
           while(r < k){
             int total = nums[l] + nums[r] + nums[k];
             //Collect result
             if(total == 0){
                result.add(Arrays.asList(nums[l], nums[r], nums[k]));
                r++;
                k--;
                while(r < k && nums[r] == nums[r-1]){
                    r++;
                }
                while(r < k && nums[k] == nums[k+1]){
                    k--;
                }
             }else if(total < 0){
                r++;
             }else{
                k--;
             }
           }
            l++;
        }
        return result;
    }
}
