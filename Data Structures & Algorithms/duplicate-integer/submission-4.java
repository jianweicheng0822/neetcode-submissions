class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            if(s.contains(n)){
                return true;
            }
            s.add(n);
        }
        return false;
    }
}