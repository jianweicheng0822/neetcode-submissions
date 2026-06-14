class Solution {
    /*
    
    1                                          2                           3
 
   1(T) 2 3        

1(T) 2(T) 3    1(T) 3(T)  2

1(T) 2(T) 3(T)  1(T) 3 (T) 2(T)

boolean[] used 
int index

backtrack(){
Terminal condition -> index == nums.length or all used 
collect the result

for()  i == 0 < nums.length
 if(used[i])  


}
    

    
    
    */
    private List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length ==0){
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        boolean[]used = new boolean[nums.length];
        backtrack(nums, 0, used, new ArrayList<>());
        return res;
    }
    private void backtrack(int[]nums, int index, boolean[]used, List<Integer> path){
          if(index == nums.length){
            res.add(new ArrayList<>(path));
            return;
          }
          for(int i =0; i < nums.length; i++){
             if(used[i]){
                continue;
             }
             used[i] = true;
             path.add(nums[i]);
             backtrack(nums, index+1, used, path);;
             used[i] = false;
             path.remove(path.size()-1);
          }
    }
}
