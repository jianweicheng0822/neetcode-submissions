class Solution {
    /*
    1 2 2 3 4     6

                       ""
                   1  2  2  3  4   
                (2,2,3,4)               remove duplicate at same level.
              3  3     4      5
            (2,3,4) (3,4) (3)        
           
            sort the array
            startIndex  -> force to go straight forward
    */
    private int sum;
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length ==0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        sum =0;
        Arrays.sort(candidates);
        backtrack(candidates, target, new ArrayList<>(), 0);
        return res;
    }
    private void backtrack(int[] candidates, int target,List<Integer> path, int startIndex){
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            if(i > startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, path, i+1);
            sum -= candidates[i];
            path.remove(path.size()-1);
        }
    }
}
