class Solution {
    /**
    
    two heaviest stone smash them
    **/
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones){
            pq.offer(stone);
        }
        while(pq.size() >=2){
            int a = pq.poll();
            int b = pq.poll();
            if(a - b != 0){
                pq.offer(a-b);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
