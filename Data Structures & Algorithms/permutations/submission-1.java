class Solution {
    /*
    intput : unique integers, 1d array

    Output : return all permutations , List<List<Integer>> res
   
   Note : Order matters
   Approach:
   nums = [1,2 ,3]

   1    2 3    for loop from 0 to nums.length     if that is not visited, we just pick the number. if all visited, we collect result.
  2 3   1 3 
 3    2 3

 when it comes to leaf node, we collect result 

 [1,2,3], [1,3,2], [2,1,3], [2,3,1]
       

     

    
    
    */
    private List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
       result = new ArrayList<>();
       boolean[]visited = new boolean[nums.length];
       backtrack(nums, visited, new ArrayList<>());
       return result;
    }
    private void backtrack(int[]nums, boolean[]visited, List<Integer> path){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path)); // save the current state and add it.
            return;
        }
        for(int i =0; i < nums.length; i++){
            if(visited[i]){
              continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtrack(nums,visited,path);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
