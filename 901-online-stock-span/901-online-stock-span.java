class StockSpanner {
    Stack<int[]> st;
    int index;
    public StockSpanner() {
        st = new Stack();
        index = 0;
    }
    
    public int next(int price) {
        
        while(!st.isEmpty() && st.peek()[1] <= price) st.pop();
        
        if(st.isEmpty()) {
            st.push(new int[]{index, price});
            index++;
            return index;
        } else{
            int peekIndex = st.peek()[0];
            st.push(new int[]{index, price});
            index++;
            return index - peekIndex-1;
        }
        
    }
    
    /*
    st- [{0, 100}, {1, 80}, {5, 75}, {6, 85}]
    index = 5
    
    span = 1, 1, 1, 2, 1, 4, 
    
    
    
    */
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */