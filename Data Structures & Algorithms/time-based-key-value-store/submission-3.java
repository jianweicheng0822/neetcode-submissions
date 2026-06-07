class TimeMap {
    class Pair{
        String value;
        int time;
        Pair(String value, int time){
            this.value = value;
            this.time = time;
        }
    }
    private Map<String, List<Pair>> m; 
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!m.containsKey(key)){
            m.put(key, new ArrayList<>());
        }
        m.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> p = m.get(key);
        if(p == null){
            return "";
        }
        int l = 0;
        int r = p.size()-1;
        String result = "";
        while(l <= r){
            int m = l + (r - l)/2;
            
            if(p.get(m).time <= timestamp){
                l = m+1;
                result = p.get(m).value;
            }else{
                r = m-1;
            }
        }
        return result;
    }
}
