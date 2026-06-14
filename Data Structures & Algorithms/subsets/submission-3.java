class Solution {
    /*
     Input :  nums =  [1,2,3]

    Approach:
              []
    [1]          [2]       [3]   
  [1,2] [1,3]   [2,3]      
[1,2,3]
    startIndex to force picking elements forward
    */
    private List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, 0);
        return res;
    }
    private void backtrack(List<Integer> path, int[] nums, int startIndex){
           res.add(new ArrayList<>(path));
           for(int i =startIndex; i < nums.length; i++){
                 path.add(nums[i]);
                 backtrack(path, nums, i+1);
                 path.remove(path.size()-1);
           }
    }
}
