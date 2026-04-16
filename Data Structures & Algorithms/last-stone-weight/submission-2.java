class Solution {
    /*
    intput:  array of stones
    Rule:
two heaviest stones, with x and y.

if  x == y, both stones are destoryed
if  x < y, x is destoryed, y has a new weight y -x.


output: return the weight of last stone or 0 if none remain

Examples:

 arr :  [2 5 4 6 9 1 3]

  1st : 9 -6  = 3, arr[1 ]
  2nd :1
    
    arr [1]
PriorityQueue as max-heap to store the arr's values. every time we just poll two heavies stones, and smash them
    */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        for(int weight : stones){
            pq.add(weight);
        }
        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();
            if(y < x){
                pq.offer(x-y);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        return pq.poll();
    }
}
