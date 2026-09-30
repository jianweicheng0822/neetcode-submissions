class Solution {
    /*
    
    
    Problem : Group all anagrams together into sublists

    Edge case:
    1. strs is null or strs.length == 0

    act  : act, cat
    
    
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length ==0){
            return new ArrayList<>();
        }
        Map<String,List<String>> m = new HashMap<>();
        for(String s : strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sort = new String(ch);
            if(!m.containsKey(sort)){
                m.put(sort, new ArrayList<>());
            }
            m.get(sort).add(s);
        }
        return new ArrayList<>(m.values());

    }
}
