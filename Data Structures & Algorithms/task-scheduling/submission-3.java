class Solution {
    public int leastInterval(char[] tasks, int n) {
        
    
    /*
    
    input : int[] tasks, int n - 
    Rule: tasks[i] A to Z

    Cycle 

    output: the minimum number of CPU cycle required to complete all tasks

    Examples:
    tasks :  [A,A,B, B,C]  n = 3

    A->B->C->idle->A->B
    output:6
    
    tasks :  [A, A, A, B, B,C]  n = 3
    A->B->C->idle->A->B->idle->idle->A

    output : 9
    
  
    Edges cases:
    1. empty array or null
  
    Approach:
        tasks :  [A, A, A, B, B,C]  n = 3
    A->B->C->idle->A->B->idle->idle->A
    (maxFreq - 1) * (n + 1) =  (3 -1 ) * (4) = 8 
    output : 9

    m : {A : 2， B :2, C :1}
    A->B->C->idle->A->B
    maxFreq = 3
    4 + numbers of maxFreq
    

    Input: tasks = ["X","X","Y","Y"], n = 2

    X->Y->idle->X->Y 
    Output: 5

    formula:
    (maxFreq -1) * (n + 1) + numberOfMaxFReq 

    Edge cases:
    tasks [A ....... Z]  n =2
    A B C  -> tasks.length  no idle needed
    return tasks.length

    Case 1: Enough tasks
    Case 2: formula

    return math.max(formula, task.length());
    */
    if(tasks == null || tasks.length == 0){
        return 0;
    }
    int maxFreq = Integer.MIN_VALUE;
    int numberOfMaxFreq = 0;
    Map<Character, Integer> m = new HashMap<>();
    for(char c : tasks){
        m.put(c, m.getOrDefault(c, 0) + 1);
        maxFreq = Math.max(maxFreq,m.get(c));
    }
    for(int v : m.values()){
        if(v == maxFreq){
            numberOfMaxFreq++;
        }
    }
    int res = (maxFreq -1) * (n + 1) + numberOfMaxFreq;
    return Math.max(res, tasks.length);

}
}
