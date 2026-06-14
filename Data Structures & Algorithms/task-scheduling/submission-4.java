class Solution {
    /*
    A A A B B B C  n  =3

    A -> B -> C -> idle ->  A -> B -> idle -> idle -> A ->B  10
    A -> B -> C -> Idle -> A -> Idle -> Idle -> Idle -> A.   9
    or tasks.length()
       
    
    Math formula :  (maxFreq - 1) * (n+1) =  2 * 4 + MaxFreqNumbers
    
    */
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length ==0){
            return 0;
        }
        int maxFreq =0;
        int numberMaxFreq = 0;
        Map<Character, Integer> m = new HashMap<>();
        for(char task : tasks){
            m.put(task, m.getOrDefault(task, 0) + 1);
            maxFreq = Math.max(maxFreq, m.get(task));
        }
       for (int freq : m.values()) {
            if (freq == maxFreq) {
                numberMaxFreq++;
            }
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n+1) + numberMaxFreq);
    }
}
