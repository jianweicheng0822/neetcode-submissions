class Solution {
    /*
    5
    4
    3
    2
    1
    
    
    */
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
