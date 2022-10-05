class StockSpanner {
    Stack<int[]> st;
    int index;
    public StockSpanner() {
        st = new Stack();
        index = -1;
    }
    
    public int next(int price) {
        index++;
        while(!st.isEmpty() && st.peek()[1] <= price) st.pop();
        
        if(st.isEmpty()) {
            st.push(new int[]{index, price});
            return index+1;
        } else{
            int peekIndex = st.peek()[0];
            st.push(new int[]{index, price});
            return index - peekIndex;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */