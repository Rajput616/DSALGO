class MyQueue {
    Stack<Integer> st, helper;

    public MyQueue() {
        st = new Stack();
        helper = new Stack();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(helper.isEmpty()){
            while(!st.isEmpty()) helper.push(st.pop());
        }
        return helper.pop();
    }
    
    public int peek() {
        if(helper.isEmpty()){
            while(!st.isEmpty()) helper.push(st.pop());
        }
        return helper.peek();
    }
    
    public boolean empty() {
        return st.isEmpty() && helper.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */