class Solution {
    /*
    Set : {2 3 4 5 10 20}
           
    
    */ 
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            s.add(n);
        }
        int result = 0;
        for(int n : nums){
            if(!s.contains(n-1)){
               int count =1;
               while(s.contains(n+1)){
                   count++;
                   n++;
               }
               result = Math.max(result, count); 
            }
        }
        return result;
    }
}
