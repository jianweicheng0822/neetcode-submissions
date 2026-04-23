class Solution {
    /*
Input :  
        nums - 1d array
        target - integer
Output:
      list of all unique combinations of nums -> chosen numbers's sum == target

Rule:
you can choose from nums with unlimited time, freq

Approach:

Input:
nums = [2,5,6,9]
target = 9

Output: [[2,2,5],[9]]

   2
  2 5 6 9 
4 2 5 

for(int i =0; i < nums.length; i++){
    backtrack(i, )
 
 }

      2
     2
    2 
   2 //backtrack
  2 // backtrack    


    
    */
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        //Arrays.sort(nums);
        res = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), 0);
        return res;
    }
    private void backtrack(int[]nums, int target, int sum, List<Integer> path, int start){
          if(sum > target){
             return;
          }
          if(sum == target){
            res.add(new ArrayList<>(path));
            return;
          }
          for(int i =start; i < nums.length; i++){
            
            path.add(nums[i]);
            sum+=nums[i];
            backtrack(nums,target, sum, path, i);
            path.remove(path.size() -1);
            sum-=nums[i];
          }
    }
}
