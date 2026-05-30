class Solution {
    /*
    nums = [3 4 5 6] target = 7
            
    m : {3:0, 4:1, 5:2, 6:3}
      
    3 + 4
    
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i =0 ; i < nums.length; i++){
            int diff = target - nums[i];
            if(m.containsKey(diff)){
                    return new int[]{m.get(diff), i};
        
            }
             m.put(nums[i],i);
        }
        return new int[]{};
    }
}
