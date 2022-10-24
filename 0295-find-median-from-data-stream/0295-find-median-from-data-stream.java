class MedianFinder {
    PriorityQueue<Integer> dec, inc;
    int sizeD, sizeI;
    public MedianFinder() {
        dec = new PriorityQueue(Comparator.reverseOrder());
        inc = new PriorityQueue();
        sizeD = sizeI = 0;
    }
    
    public void addNum(int num) {
        if(dec.isEmpty() || num <= dec.peek()) {
            dec.add(num);
            sizeD++;
        } else{
            inc.add(num);
            sizeI++;
        }
        
        if(sizeD - sizeI > 1 || sizeD - sizeI < 0) equalize();
    }
    
    public double findMedian() {
        if((sizeD + sizeI) % 2 != 0) return dec.peek();
        else return (double)(dec.peek() + inc.peek()) / 2.0;
    }
    
    private void equalize(){
        while(sizeD - sizeI > 1 || sizeD - sizeI < 0){
            if(sizeD > sizeI){
                inc.add(dec.poll());
                sizeD--;
                sizeI++;
            } else{
                dec.add(inc.poll());
                sizeD++;
                sizeI--;
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */