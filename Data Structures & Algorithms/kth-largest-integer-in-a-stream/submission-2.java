class KthLargest {
/*

kth largest integer

including duplicates

Example:


KthLargest {3,  {1,2,3,3,3}}
1
2
3

pq :  {3 3 3 2 1}

nums :  1 2 3 3 
int k : 2

pq :  3 3 
 
use the min-heap to solve this problem

keep adding the value to the min-heap, if it goes out of the k size, we just poll it.


*/ private   PriorityQueue<Integer> pq = new PriorityQueue<>();
   private int size = 0;
    public KthLargest(int k, int[] nums) {
        size = k;
        for(int n : nums){
            pq.add(n);
            if(pq.size() > k){
                pq.poll();
            }
        }
    } 
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > size){
            pq.poll();
        }
        return pq.peek();
    }
}
