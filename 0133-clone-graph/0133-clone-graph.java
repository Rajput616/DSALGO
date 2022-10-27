/*
// Definition for a Node.
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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap();
        Set<Node> set = new HashSet();
        Node root = new Node(node.val);
        map.put(node, root);
        Queue<Node> q = new LinkedList();
        q.offer(node);
        set.add(node);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node curr = q.poll();
                Node mapNode = map.get(curr);
                for(Node neigh : curr.neighbors){
                    Node mapNeigh = map.getOrDefault(neigh, new Node(neigh.val));
                    map.putIfAbsent(neigh, mapNeigh);
                    mapNode.neighbors.add(mapNeigh); 
                    if(set.add(neigh)){  
                        q.offer(neigh);
                    }
                        
                }
            }
        }
        return root;
    }
}