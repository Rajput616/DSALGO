class MinStack {
    Stack<Long> st; 
    Long min;
    public MinStack() {
        st = new Stack();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long newVal = Long.valueOf(val);
        if(st.isEmpty()){
            st.push(newVal);
            min = newVal;
        } else if(newVal < min){
            st.push(2*newVal - min);
            min = newVal;
        } else{
            st.push(newVal);
        }
    }
    
    public void pop() {
        if(min > st.peek()) min = 2*min-st.peek();
        st.pop();
    }
    
    public int top() {
        if(min > st.peek()) return min.intValue();
        return st.peek().intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */