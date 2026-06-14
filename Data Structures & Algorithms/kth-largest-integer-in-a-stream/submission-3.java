class KthLargest {
/*
1 2 3 k =1


1 2 3 3   k=3 

5 6 7   pq.size() == k

PQ.add all numbers 

    


*/
private PriorityQueue<Integer> pq;
private int size =0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        for(int i : nums){
            pq.offer(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        size = k;
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > size){
            pq.poll();
        }
        return pq.peek();
    }
}
