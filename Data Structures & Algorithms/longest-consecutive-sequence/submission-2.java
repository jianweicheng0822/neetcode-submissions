class Solution {
    public int longestConsecutive(int[] nums) {
        /*
        
        Map<>


        */
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            s.add(n);
        }
        int res = 0;
        for(int n : nums){
            //Start point
            if(!s.contains(n-1)){
                int number  = n;
                int count = 0;
                while(s.contains(number++)){
                    count++;
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }
}
