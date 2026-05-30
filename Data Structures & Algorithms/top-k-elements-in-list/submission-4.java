class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i : nums){
            m.put(i, m.getOrDefault(i,0) +1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> m.get(b) - m.get(a));
        for(int i : m.keySet()){
            pq.offer(i);
        }
        int[] res = new int[k];
        for(int i = 0; i < k;i++){
            res[i] = pq.poll();
        }
        return res;
        }
       
    }

