class Solution {
    /*
    2 20 4 10 3 4 5

    2 3 4 5

    Map: 
     
     2 
     3
     4
     5
    
    Use Set to check to find the start point to find the longest consecutive numbers

    */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }    
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            s.add(n);
        }
        int output = 0;
        for(int n : nums){
            if(!s.contains(n-1)){
                int number = n;
                int count  =0;
               while(s.contains(n)){
                  n++;
                  count++;
               }
               output = Math.max(output,count);
            }
        }
        return output;
    }
}
