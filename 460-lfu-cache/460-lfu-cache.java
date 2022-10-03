class Node{
    int key, value, freq;
    Node prev, next;
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DLL{
    Node head, tail;
    int size;
    DLL(){
        this.size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public void addNode(Node node){
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
        this.size++;
    }
    
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.size--;
    }
}

class LFUCache {
    int capacity, minFreq, currSize;
    Map<Integer, Node> cache;
    Map<Integer, DLL> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        currSize = minFreq = 0;
        cache = new HashMap();
        freqMap = new HashMap();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            update(curr);
            return curr.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        
        if(cache.containsKey(key)){
            Node curr = cache.get(key);
            curr.value = value;
            update(curr);
        } else{
            currSize++;
            if(currSize > capacity){
                DLL minFreqList = freqMap.get(minFreq);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
            } 
            this.minFreq = 1;
            Node node = new Node(key, value);
            DLL currList = freqMap.getOrDefault(1, new DLL());
            currList.addNode(node);
            freqMap.put(1, currList);
            cache.put(key, node);
        }
    }
    
    public void update(Node node){
        int currFreq = node.freq;
        DLL currList = freqMap.get(currFreq);
        currList.removeNode(node);
        
        if(currFreq == minFreq && currList.size == 0) minFreq++;
        
        node.freq++;
        DLL list = freqMap.getOrDefault(node.freq, new DLL());
        list.addNode(node);
        freqMap.put(node.freq, list);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */