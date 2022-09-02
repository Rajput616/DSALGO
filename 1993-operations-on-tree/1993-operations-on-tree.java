class Node{
    int val, parent, user;
    boolean isLocked;
    ArrayList<Node> children;
    Node(int val, boolean isLocked, int parent){
        this.val = val;
        this.isLocked = isLocked;
        this.parent = parent;
        children = new ArrayList();
    }
    void lockNode(int user){
        this.isLocked = true;
        this.user = user;
    }
    
    void unlockNode(){
        this.isLocked = false;
    }
}
class LockingTree {
    HashMap<Integer, Node> map;
    public LockingTree(int[] parent) {
        map = new HashMap();
        //Constructing Tree
        for(int i = 0; i < parent.length; ++i){
            Node node = map.getOrDefault(i, new Node(i, false, parent[i]));    
            if(i > 0){
                Node ancestor = map.getOrDefault(parent[i], new Node(parent[i], false, parent[parent[i]]));
                ancestor.children.add(node);
                map.put(ancestor.val, ancestor);
            }
            map.put(i, node);
        }
        // printTree(0);
    }
     /*
                             -1 -> 0
                              4 -> 1
                              0 -> 2
                              2 -> 3
                              5 -> 4
                              0 -> 5
                              4 -> 6
                              8 -> 7
                              2 -> 8
                              4 -> 9
                                
                             0
                            /  \
                           2   ``5
                          / \   /
                         3   8 4   
                               / \ 
                              1   6
                          / \
                         5   9
                            /  
                           2
    */
    
    private void printTree(int num){
        Node node = map.get(num);
        Queue<Node> q = new LinkedList();
        q.offer(node);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node front = q.poll();
                System.out.print(front.val + " ");
                for(Node child : front.children) q.offer(child);
            }
            System.out.println();
        }
    }
    
    public boolean lock(int num, int user) {
        Node node = map.getOrDefault(num, null);
        if(node == null || node.isLocked) return false;
        node.lockNode(user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        Node node = map.getOrDefault(num, null);
        if(node == null) return false;
        if(!node.isLocked || user != node.user) return false;
        node.unlockNode();
        return true;
    }
    
    public boolean upgrade(int num, int user) {
        Node node = map.getOrDefault(num, null);
        if(node == null || node.isLocked) return false;
        if(isAncestorLocked(num) || !checkLockedDescendants(num)) return false;
        node.lockNode(user);
        freeAllItsChild(map.get(num));
        return true;
    }
    
   
    
    private boolean isAncestorLocked(int num){
        if(num == -1) return false;;
        Node node = map.getOrDefault(num, null);
        if(node == null) return false;
        if(node.isLocked) return true;
        return isAncestorLocked(node.parent);
    }
    
    private boolean checkLockedDescendants(int num){
        Queue<Node> q = new LinkedList();
        Node node = map.getOrDefault(num, null);
        if(node == null) return false;
        for(Node child : node.children) q.offer(child);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node front = q.poll();
                if(front.isLocked) return true;
                for(Node child : front.children) q.offer(child);
            }
        }
        return false;
    }
    
    private void freeAllItsChild(Node node){
        if(node == null) return;
        Queue<Node> q = new LinkedList();
        for(Node child : node.children) q.offer(child);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Node front = q.poll();
                if(front.isLocked) front.unlockNode();
                for(Node child : front.children) q.offer(child);
            }
        }
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */