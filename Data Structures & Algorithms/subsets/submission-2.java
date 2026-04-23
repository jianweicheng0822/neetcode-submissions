class Solution {
    /*
    input :  unique integers

    Rule:
    no duplicate subsets. any order
    
    output: all possible subsets of nums

What is the subset? Order not mattered
1 2 3 -> 3 2 1 
we want to avoid duplicate subsets


nums = [1 2 3]

  1          2       3     startIndex -> End
 1,2 1,3     2,3            startIndex + 1
1,2,3                       
    
    */
    private List<List<Integer>>  res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums);
        return res;
    }
    private void backtrack(List<Integer> path, int startIndex, int[] nums){
     //Collect result
       res.add(new ArrayList<>(path));
       for(int i =startIndex; i < nums.length; i++){
            path.add(nums[i]);
            backtrack(path, i+1, nums);
            path.remove(path.size()-1);
       }
    }
}
