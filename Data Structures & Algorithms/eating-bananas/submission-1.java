class Solution {
    /*
    
    piles[i]
    
    1 4 3 2 
  
    find the minimum integer k that can eat all banans with in h hours
    
    */
    public int minEatingSpeed(int[] piles, int h) {
       int l =1;
       int r =0;
       for(int i : piles){
        r = Math.max(r, i);
       }
       int result = 0;
       while(l <=r){
         int mid = l + (r -l)/2;
         long time = 0;
         for(int i : piles){
             time += Math.ceil((double) i / mid);
         }
         if(time <= h){
            result = mid;
            r = mid-1;
         }else{
            l = mid+1;
         }
       }
       return result;
    }
}
