class LockingTree {
    Map<Integer, Integer> locked = new HashMap();
    int[] parent;
    public LockingTree(int[] parent) {
        this.parent = parent;
    }
    
    public boolean lock(int num, int user) {
        if(locked.containsKey(num)) return false;
        locked.put(num, user);
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(locked.containsKey(num) && locked.get(num) == user){
            locked.remove(num);
            return true;
        }
        return false;
    }
    
    public boolean upgrade(int num, int user) {
        if(locked.containsKey(num)) return false;
        int node = num;
        while(node != -1){
            node = parent[node];
            if(locked.containsKey(node)) return false;
        }
        boolean isLockedChildPresent = false;
        for(int loc : locked.keySet()){
            if(isChild(loc, num)) {
                isLockedChildPresent = true;
                break;
            }
        }
        if(!isLockedChildPresent) return false;
        Iterator it = locked.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
            if(isChild(entry.getKey(), num)){
                it.remove();
            }
        }
        locked.put(num, user);
        return true;
    }
    private boolean isChild(int i, int num){
        int node = i;
        while(node != -1){
            node = parent[node];
            if(node == num) return true;
        }
        return false;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */