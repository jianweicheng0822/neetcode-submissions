class Solution {
    /*
    nums = [2 5 6 9]
    target = 9



Backtracking:
pick elements repeatly, but if sum is greater than target, we cut it from our tree.
    */
    private List<List<Integer>> res;
    private int sum;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(nums == null || nums.length ==0){
            return new ArrayList<>();
        }
        sum = 0;
        Arrays.sort(nums);
        res = new ArrayList<>();
        backtrack(nums, target, 0, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums, int target, int sum, int start, List<Integer> path){
           if(sum > target){
             return;
           }
           if(sum == target){
               res.add(new ArrayList<>(path));
               return;
           }
           for(int i =start; i < nums.length; i++){
              if(i > start && nums[i] == nums[i-1]){
                continue;
              }
              path.add(nums[i]);
              sum+= nums[i];
              backtrack(nums, target, sum,i, path);
              sum-= nums[i];
              path.remove(path.size()-1);
           }

    }
}
