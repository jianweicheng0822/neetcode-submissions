class Solution {
    /*
    input :  array nums of integers, may contain duplicates
    
    output: return all possible subsets (order doesn't matter)
    
    Examples:

    nums = [1,1,2]
   
    []
  level 0 : 1 1 2
  [1], [1,1], [1,1,2], [1,2]
  level 1:  
  
   
   
    Edge case:
    1.empty array or null 
    */
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length ==0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(int[]nums, int start, List<Integer> path){
          //Terminal condition
          res.add(new ArrayList<>(path));
          for(int i = start; i < nums.length; i++){
             if(i > start && nums[i] == nums[i -1]){
                continue;
             }
             path.add(nums[i]);
             backtrack(nums, i+1, path);
             path.remove(path.size()-1);
          }
    }
}
