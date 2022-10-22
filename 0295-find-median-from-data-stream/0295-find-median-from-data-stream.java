class MedianFinder {
    PriorityQueue<Integer> inc, dec;
    public MedianFinder() {
        dec = new PriorityQueue<>(Collections.reverseOrder());
        inc = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if(dec.isEmpty() || num <= dec.peek()) dec.add(num);
        else inc.add(num);
        
        if(dec.size() - inc.size() > 1 || dec.size() - inc.size() < 0) equalize();
    }
    
    private void equalize(){
        while(dec.size() - inc.size() > 1 || dec.size() - inc.size() < 0){
            if(dec.size() > inc.size()) {
                int pop = dec.remove();
                inc.add(pop);
            } else{
                int pop = inc.remove();
                dec.add(pop);
            }
        }
    }
    
    public double findMedian() {
        if((dec.size() + inc.size()) % 2 != 0) return dec.peek();
        else return ((double)inc.peek() + (double)dec.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */