class LRUCache {
/*
System design problem
LRU cache

get(): 


put() : update the value of key if key exists. 


Examples:
capacity -> 2 
put(1,10)    
put(2,10)     2 -> 1 
put(3,10)     2->3
get(2).       

The question how to get the most recently used key. 

HashMap + Double Linked List
- addNode()
- removeNode()
*/
class Node{
    int key;
    int val;
    Node prev;
    Node next;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
private Map<Integer, Node> m;
private Node head;
private Node tail;
private int size;
    public LRUCache(int capacity) {
        m = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        size = capacity;
    }
    
    public int get(int key) {
        if(!m.containsKey(key)){
            return -1;
        }
        Node n = m.get(key);
        remove(n);
        add(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        //Update the value
        if(m.containsKey(key)){
            Node old = m.get(key);
            m.remove(old.key);
            m.put(key, newNode);
            remove(old);
            add(newNode);
        }else{
            m.put(key, newNode);
            add(newNode);
        }
        if(m.size() > size){
            Node n = tail.prev;
            remove(n);
            m.remove(n.key);
        }
    }
    private void add(Node n){
      Node next = head.next; 
      head.next = n;
      n.prev = head;
      n.next = next;
      next.prev = n;
    }
    /*
    head<->1<->2<->3->tail
     
    head<->1<->3<-> tail 
    */
    private void remove(Node n){
         Node prev = n.prev; // 1
         prev.next = n.next; // 1->3
         n.next.prev = prev; // 1<->3
    }
}
