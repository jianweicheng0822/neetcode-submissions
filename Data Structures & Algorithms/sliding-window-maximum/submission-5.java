class Solution {
    /*
   Input: nums = [1,2,1,0,4,2,6], k = 3
   Output: List of max elements at each step.
   
   int[] res = new int[nums.length - k +1]

   [1 2 1] 0 4 2 6 max : 2
   1 [2 1 0] 4 2 6 max 2
   Edge case:
   nums is null or empty, k <= 0 
   
   Optimized:
    nums = [3,2,1,0,4,2,6]
              l
                  r
    index.  0 1 2 3 4 5 6

    Sliding window:
    PriorityQueue<int[]>
    window size = r-l+1 reaches k, and store result  
    */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]res = new int[nums.length - k +1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int l =0;
        int r =0;
        while(r < nums.length){
            pq.offer(new int[]{nums[r], r});
            if(r - l + 1 == k){
                //poll the out of window elements
              while(pq.peek()[1]  < l){
                pq.poll();
              }
              res[l] = pq.peek()[0];
              l++;
            }
            r++;
        }
        return res;
    }
}
