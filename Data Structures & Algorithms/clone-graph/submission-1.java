/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
/*

[1 : 1]
[2 : 2]  1->2
         3  4


1 -> 2 -> 3 

m  = { 1, 1 }
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> m = new HashMap<>();
        m.put(node, new Node(node.val));
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(Node nei : cur.neighbors){
                if(!m.containsKey(nei)){
                    m.put(nei, new Node(nei.val));
                    q.offer(nei);
                }
                m.get(cur).neighbors.add(m.get(nei));
            }
        }
        return m.get(node);
    }
    
}