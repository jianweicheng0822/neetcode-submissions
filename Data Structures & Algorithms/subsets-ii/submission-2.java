class Solution {
    /*
    

   nums = [1 2 1 ]
   sort nums = [1 1 2]
         ""  level 0
    1                  1    2   level 1
[1, 1][1,2]          [1,2]   [2]        we want to remove the duplicate at the same level  
[1,1,2]     
    

    We can use startIndex -> force to stragiht forward loop through the array

    if i > startIndex && nums[i] == nums[i -1]
      continue

    backtrack(){
    
    */
    private List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //Handle the Edge case : NULLPOINTER Exception
        if(nums == null || nums.length ==0){
            return new ArrayList<>(); // empty
        }
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums, int startIndex, List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i = startIndex; i < nums.length; i++){
            if(i > startIndex && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, i+1, path);
            path.remove(path.size()-1);
        }
    }
}
