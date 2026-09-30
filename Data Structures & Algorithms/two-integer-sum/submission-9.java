class Solution {
/*
Find two indicated that matches the output

Edge case:
1. num is null 
2. length of nums is less than size of 2

Example:
[1,2,3,4]  target = 5

1 + 4 = 5
2 + 3 = 5

1 : 0
2 : 1
3 : 2
4 : 3


Brute Approach:
1 
   2 3 4 
2
   1 3 4
3
   1 2 4
4 
   1 2 3 
HashMap O(n):


1 2 3 4            target  5

5 -1  =4 
1:0
2:1
3:
output:  [1,2]

*/
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2){
            return new int[]{};
        }
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            int diff = target - nums[i]; //4 
            if(m.containsKey(diff) && !m.get(diff).equals(i)){
                return new int[]{m.get(diff), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{};
    }
}
