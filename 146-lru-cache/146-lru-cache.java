class LRUCache {
    int size;
    DLL head, tail;
    HashMap<Integer, DLL> map;
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap();
        head = new DLL(0, 0);
        tail = new DLL(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            DLL node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == size){
            remove(tail.prev);
        }
        insert(new DLL(key, value));
    }
    public void remove(DLL node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void insert(DLL node){
        map.put(node.key, node);
        DLL headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
}

public class DLL{
    int key, val;
    DLL prev, next;
    DLL(int key, int val){
        this.key = key;
        this.val = val;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */