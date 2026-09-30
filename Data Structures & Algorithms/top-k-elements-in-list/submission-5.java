class Solution {
    /*
    Problem:
    return the k most frequent elements within the array

    Edge case:
    1. nums == null || nums.length == 0
    2. nums.length < k 
    
    HashMap to count the frequency

    1 : 1
    2 : 2
    3 : 3
    */
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length ==0 || nums.length < k){
            return new int[]{};
        }
        int[] output = new int[k];
        Map<Integer, Integer> m = new HashMap<>();
        for(int n : nums){
            m.put(n, m.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> m.get(b) - m.get(a)); // max heap
        int index = 0;
        for(int n : m.keySet()){
            pq.offer(n);
        }
        while(k > 0){
            output[index] = pq.poll();
            index++;
            k--;
        }
        return output;
    }
}
